package create.builder;

import com.sun.media.sound.SoftChorus;

/**
 * @Author weiwo
 * @Created on 2021/9/5
 * @Content
 */
public class CourseBuilder implements ICourseBuilder{

    private  Course course=new Course();
    public CourseBuilder addName(String name){
        course.setName(name);
        return this;
    }
    public  CourseBuilder addPpt(String ppt){
        course.setPpt(ppt);
        return this;
    }
    public CourseBuilder addVideo(String video){
        course.setVideo(video);
        return this;
    }
    public CourseBuilder addNode(String note){
        course.setNote(note);
        return this;
    }
    public CourseBuilder addHomework(String homework){
        course.setHomework(homework);
        return this;
    }
    public Course build(){
        return  course;
    }


    public static void main(String[] args) {
        //客户端测试
        CourseBuilder builder=new CourseBuilder();
        builder.addName("asd")
                .addHomework("homework")
                .addNode("node")
                .addPpt("asd")
                .addVideo("v");

        System.out.println(builder.build());

    }
}
