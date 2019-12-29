package com;

import com.test.Course;
import com.test.Student;
import com.test.Teacher;

import java.util.List;

public class PageInfo {
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Course> courseList;
    //开始页码
    private int beginPage;
    //结束页码
    private int endPage;
    //当前页号
    private int currentPage;
    //总页数
    private int totalPages;
    //总记录数
    private long totalRecord;

    public PageInfo(List<Course> list, int currentPage, long totalRecord) {
        this.courseList = list;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;

        //总页数计算
        if (totalRecord % 4 == 0) {
            this.totalPages = Math.toIntExact(totalRecord) / 4;
        } else {
            this.totalPages = Math.toIntExact(totalRecord) / 4 + 1;
        }

        //中间页码显示6页码
        if (this.totalPages < 6) {
            this.beginPage = 1;
            this.endPage = totalPages;
        } else {
            this.beginPage = currentPage - 3;
            this.endPage = currentPage + 2;
        }

        if (this.beginPage < 0) {
            this.beginPage = 1;
        }
        if (this.endPage > this.totalPages) {
            this.beginPage = this.totalPages;
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
