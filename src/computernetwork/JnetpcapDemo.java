package computernetwork;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JnetpcapDemo {

    public static void main(String[] args) {
        List<PcapIf> alldevs = new ArrayList<PcapIf>(); // Will be filled with
        // NICs
        StringBuilder errbuf = new StringBuilder(); // For any error msgs

        /***************************************************************************
         * First get a list of devices on this system
         **************************************************************************/
        int r = Pcap.findAllDevs(alldevs, errbuf);
        if (r == Pcap.NEXT_EX_NOT_OK || alldevs.isEmpty()) {
            System.err.printf("Can't read list of devices, error is %s",
                    errbuf.toString());
            return;
        }
        System.out.println("Network devices found:");
        // 迭代找到的所有网卡
        int i = 0;
        for (PcapIf device : alldevs) {
            String description = (device.getDescription() != null) ? device
                    .getDescription() : "No description available";
            System.out.printf("#%d: %s [%s]\n", i++, device.getName(),
                    description);
        }

        PcapIf device = alldevs.get(6); // We know we have at least 1 device 选择监听那个网卡
        System.out.printf("\nChoosing '%s' on your behalf:\n",
                (device.getDescription() != null) ? device.getDescription()
                        : device.getName());
        /***************************************************************************
         * Second we open up the selected device
         **************************************************************************/
        // 截取长度不超过数据报max65535
        int snaplen = 64 * 1024; // Capture all packets, no trucation 截断
        // 混杂模式
        int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
        int timeout = 10 * 1000; // 10 seconds in millis
        Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout,
                errbuf);

        if (pcap == null) {
            System.err.printf("Error while opening device for capture: "
                    + errbuf.toString());
            return;
        }

        /***************************************************************************
         * Third we create a packet handler which will receive packets from the
         * libpcap loop.
         **************************************************************************/

        //PacketHandler处理

        /***************************************************************************
         * Fourth we enter the loop and tell it to capture 10 packets. The loop
         * method does a mapping of pcap.datalink() DLT value to JProtocol ID,
         * which is needed by JScanner. The scanner scans the packet buffer and
         * decodes the headers. The mapping is done automatically, although a
         * variation on the loop method exists that allows the programmer to
         * sepecify exactly which protocol ID to use as the data link type for
         * this pcap interface.
         **************************************************************************/
        pcap.loop(-1, new PacketHandler<String>(), "jNetPcap rocks!");

        /***************************************************************************
         * Last thing to do is close the pcap handle
         **************************************************************************/
        pcap.close();
    }
}
