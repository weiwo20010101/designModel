package create.builder;

/**
 * @Author weiwo
 * @Created on 2021/9/5
 * @Content 静态内部类实现建造者模式
 */
public class Course {
    private String name;
    private String ppt;
    private String video;
    private String note;
    private String homework;

    @Override
    public String toString(){
        return ""+note+"  "+name+"  "+video+" "+homework+" "+ppt;
    }
    public String getName(){
        return name;
    }
    public String getPpt(){
        return ppt;
    }
    public String getVideo(){
        return video;
    }
    public String getNote(){
        return note;
    }
    public String getHomework(){
        return homework;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPpt(String  ppt){
        this.ppt=ppt;
    }
    public void setVideo(String video){
        this.video=video;
    }
    public void setNote(String note){
        this.note=note;
    }
    public void setHomework(String homework){
        this.homework=homework;
    }

    static class CourseBuilder implements ICourseBuilder {

        private Course course = new Course();

        public CourseBuilder addName(String name) {
            course.setName(name);
            return this;
        }

        public CourseBuilder addPpt(String ppt) {
            course.setPpt(ppt);
            return this;
        }

        public CourseBuilder addVideo(String video) {
            course.setVideo(video);
            return this;
        }

        public CourseBuilder addNode(String note) {
            course.setNote(note);
            return this;
        }

        public CourseBuilder addHomework(String homework) {
            course.setHomework(homework);
            return this;
        }

        public Course build() {
            return course;
        }

    }

    public static void main(String[] args) {
        //客户端测试
        create.builder.CourseBuilder builder=new create.builder.CourseBuilder();
        builder.addName("asd")
                .addHomework("homework")
                .addNode("node")
                .addPpt("asd")
                .addVideo("v");

        System.out.println(builder.build());
    }
    }
