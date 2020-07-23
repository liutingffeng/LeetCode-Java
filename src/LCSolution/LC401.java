package LCSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC401 {

    class Solution {
        public List<String> readBinaryWatch(int num) {
            int[] leds = {8,4,2,1,32,16,8,4,2,1}; //前四位代表小时
            List<String> result = new ArrayList<>();
            backTrack(num, leds, 0, 0, 0, result);
            return result;
        }

        private void backTrack(int num,int[] leds,int index,int hours,int minutes,List<String> result){
            if (num == 0){
                //
                if (hours>11 || minutes>=60)
                    return;

                StringBuilder sb = new StringBuilder();
                sb.append(hours).append(':');
                if (minutes<10)
                    sb.append('0');
                sb.append(minutes);
                result.add(new String(sb));
                return;
            }

            //做选择
            for (int i=index;i<leds.length;i++){
                if (i<4)
                    hours+=leds[i];
                else
                    minutes+=leds[i];
                backTrack(num, leds, index+1, hours, minutes, result);
                if (i<4)
                    hours-=leds[i];
                else
                    minutes-=leds[i];
            }
        }
    }
}
