package LCSolution;

import java.util.*;

public class LC399 {

    class Solution {
        private Map<String,String> parent = new HashMap<>();
        // val[a] 代表 a/parent[a]
        private Map<String,Double>  values = new HashMap<>();

//        private String find(String p){
//            while (parent.get(p)!= p){
//                p = parent.get(p);
//            }
//            return p;
//        }

        /*
        路径压缩
         */
//        private String find(String p){
//            if (parent.get(p)!= p){
//                String f = parent.get(p);
//                // 注意这里
//                parent.put(p, find(f));
//                values.put(p, values.get(p)*values.get(f));
//            }
//            return parent.get(p);
//        }

        public String find(String p){
            if (parent.get(p)!=p) {
                //需要先保存父亲的值,因为后面压缩后树只有两层,后面*的就是根节点的权值1,是不对的
                //这里可以看看上面的并茶几的方向和值来判断
                String f=parent.get(p);
                parent.put(p,find(f));
                //这样压缩后的子节点才是正确的
                values.put(p,values.get(p)*values.get(f));
            }
            return parent.get(p);
        }



        private void union(String a,String b , double val){
            init(a);
            init(b);
            String fa = find(a);
            String fb = find(b);
            if (fa.equals(fb)){
                return;
            }

            //
            parent.put(fa, fb);
            //cal(a)和cal(b)代表a和b到根节点的总值
//            values.put(fa, val*(cal(b))/(cal(a)));

            // 已经路径压缩了
            values.put(fa, val*(values.get(b))/(values.get(a)));
        }

        //计算当前节点到根节点的路径乘积
        // 路径压缩后就可以不需要了
//        private double cal(String index){
//            double val = 1.0;
//            while (parent.get(index)!=index){
//                val = val*values.get(index);
//                index = parent.get(index);
//            }
//            return val;
//        }

        private void init(String p){
            if (!parent.containsKey(p)){
                parent.put(p, p);
                values.put(p, 1.0);
            }
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            for (int i = 0; i < equations.size(); i++) {
                List<String> cur = equations.get(i);
                union(cur.get(0), cur.get(1), values[i]);
            }
            double[] res = new double[queries.size()];

            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                if (!parent.containsKey(query.get(0)) || !parent.containsKey(query.get(1))){
                    res[i] = -1;
                }
                else {
                    String str0 = query.get(0);
                    String str1 = query.get(1);
                    String a = find(str0);
                    String b = find(str1);
                    // 不在一个集合里
                    if (!a.equals(b)){
                        res[i] = -1;
                    }
                    else if (str0.equals(str1)){
                        res[i] = 1;
                    }
                    else {
                        res[i] = this.values.get(str0)/this.values.get(str1);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new LC399().new Solution();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<String>(Arrays.asList(new String[]{"a", "b"})));
        equations.add(new ArrayList<String>(Arrays.asList(new String[]{"b","c"})));
        double[] values = new double[]{2.0,3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<String>(Arrays.asList(new String[]{"a","c"})));
        solution.calcEquation(equations, values, queries);
    }

}
