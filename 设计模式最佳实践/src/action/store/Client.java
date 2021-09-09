package action.store;

/**
 * @Author weiwo
 * @Created on 2021/9/9
 */
public class Client {

    public static void main(String[] args) {
     Originator originator=new Originator();
     originator.setState("state1");
        Originator.Memory memory = originator.createMemory();
      MemoryManer memoryManer=new MemoryManer();
      memoryManer.setMemory(memory);

      originator.setState("state2");
      originator.restore(memory);
        System.out.println(originator.getState());

        //快照管理者可以修改。查看内容嘛
    }

    static  class MemoryManer{
        private IMemory iMemory;

        public IMemory getMemory() {
            return iMemory;
        }

        public void setMemory(IMemory iMemory) {
        this.iMemory=iMemory;
        }
    }
    interface  IMemory{}
    static  class Originator{
        private String state;
        public String getState() {
            return state;
        }
        public void setState(String state){
            this.state= state;
        }
        //创建一个备忘录
        public Memory createMemory(){
            return new Memory(this.state);
        }

        //恢复状态 需要传参数备忘录 memory
        public void restore(IMemory iMemory){
          this.state=((Memory)iMemory).state;
        }

       private static class Memory implements  IMemory{

            private String state;
            public Memory(String state){
                this.state=state;
            }

        }
    }
}
