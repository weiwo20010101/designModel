package action.mediator;

/**
 * @Author weiwo
 * @Created on 2021/9/10
 */
public class Client {

    static class User{
        private String name;
        private  ChatRoom chatRoom;

         public User(ChatRoom chatRoom,String name){
             this.name=name;
             this.chatRoom=chatRoom;
         }
        public void say(String message){
            chatRoom.showMessage(this,message);
        }
    }
    static class ChatRoom{
        public void showMessage(User user,String message){
            System.out.println("["+user.name+"]:" +message);
        }
    }

    public static void main(String[] args) {
        ChatRoom chatRoom=new ChatRoom();
        User user =new User(chatRoom,"weiwo");
        user.say("i am weiwo");
        User user1=new User(chatRoom,"xueyin");
        user1.say("i am xueyin");
    }
}
