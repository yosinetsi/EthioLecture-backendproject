package com.example.EthioLecture.Controller;





import com.example.EthioLecture.Entity.Course;
import com.example.EthioLecture.Entity.Department;
import com.example.EthioLecture.Entity.PostedVideo;
import com.example.EthioLecture.Entity.UserAccount;
import com.example.EthioLecture.Service.CourseService;
import com.example.EthioLecture.Service.DepartmentService;
import com.example.EthioLecture.Service.UserService;
import com.example.EthioLecture.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:5173/")
public class ApplicationController {
    @Autowired
    private final UserService userService;
    private final CourseService courseService;
    private final DepartmentService departmentService;
    private final VideoService videoService;

    public ApplicationController(UserService userService, CourseService courseService, DepartmentService departmentService, VideoService videoService) {
        this.userService = userService;
        this.courseService = courseService;
        this.departmentService = departmentService;
        this.videoService = videoService;
    }

    /***
     *
     * @param userAccount
     * @ return
     */
    @PostMapping("/user")
    public ResponseEntity<String> postUser(@RequestBody  UserAccount userAccount){
        String response=userService.postUser(userAccount);
  return ResponseEntity.status(HttpStatus.OK).body(response);
}


    /***
     *
     *
     * @return
     */

    @GetMapping("departmentlist")
    public List<Department> getDepartment(){

        return departmentService.getDepratment();
    }
    @GetMapping("depsingle/{depCode}")
    public Optional<Department> getDepartement(@PathVariable("depCode") String depCode){

        return Optional.ofNullable(departmentService.getDepartementBydepCode(depCode));
    }

    /***
     *
     * @param id
     */

    @DeleteMapping("dep/{id}")
    public void deleteDepartment(@PathVariable("id") Long id){
        departmentService.deleteDepratment(id);
    }


    /***
     *
     * @param department
     * @ return
     */
    @PostMapping("/department")
    public ResponseEntity<String> postDepartment(@RequestBody Department department){
        String response= departmentService.postDepartment(department);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /***
     *
     * @param depCode
     * @param department
     * @return
     */
    @PutMapping("depupdate/{depCode}")
    public ResponseEntity<String> updateDepartment(@PathVariable("depCode") String depCode,@RequestBody Department department){
        String response= departmentService.updateDepartment(depCode,department);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    /***
     *
     * @param course
     * @ return
     */

    @PostMapping("/course")
    public ResponseEntity<String> postCourse(@RequestBody Course course){
        String response=courseService.postCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /***
     *
     * @return
     */
    @GetMapping("get-course-list")
    public List<Course> getCourse(){
        return courseService.getCourse();
    }

    /***
     *
     * @param courseCode
     * @return
     */
    @GetMapping("course-by-coursecode/{courseCode}")
    public  Optional<Course> getCourseByCourseCode(@PathVariable("courseCode") String courseCode){

        return  courseService.getCourseByCourseCode(courseCode);
    }

    /***
     *
     * @param courseCode
     * @param course
     */
    @PutMapping("update-course/{courseCode}")
    public void updateCourse(@PathVariable("courseCode") String courseCode,@RequestBody Course course){
        courseService.updateCourse(courseCode,course);
    }

    /***
     *
     * @param id
     */
    @DeleteMapping("delete/{id}")
    public void deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
    }

    /***
     *
     * @return
     */
     @GetMapping("all-video")
    public List<PostedVideo> getAllVideo(){
        return videoService.getAllVideo();
    }

    /***
     * get all video that posted for administrator purpose...
     * @param videoCode
     * @return
     */
    @GetMapping("video-by-vidoCode/{videoCode}")
    public Optional<PostedVideo> getVideoByCode(@PathVariable("videoCode") String videoCode){
        return videoService.getVideoByCode(videoCode);
    }
    /***
     *
     * @param video
     * @ return
     */
    @PostMapping("/post-video")
    public ResponseEntity<String> postVideo(@RequestBody  PostedVideo video){
        String response=videoService.postVideo(video);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /***
     * updating video profile like how post ...
     * @param videoCode
     * @param video
     */
    @PutMapping("update-video/{videoCode}")
    public void updateVideo(@PathVariable("videoCode") String videoCode,@RequestBody PostedVideo video){
        videoService.updateVideo(videoCode,video);
    }

    /***
     * removing video permanently
     * @param id
     */

   @DeleteMapping("delete-video/{id}")
    public  void removeVideo(@PathVariable("id") Long id){
        videoService.removeVideo(id);
   }


}
