package LCSolution;

import java.util.*;

public class LC341 {

    public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }

    public class NestedIterator implements Iterator<Integer> {

        List<Integer> list = new ArrayList<>();
        int index;
        public NestedIterator(List<NestedInteger> nestedList) {
            recurse(nestedList);
        }

        private void recurse(List<NestedInteger> nestedList){
            for (NestedInteger nestedInteger : nestedList){
                if (nestedInteger.isInteger()){
                    list.add(nestedInteger.getInteger());
                }
                else {
                    recurse(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }

}
