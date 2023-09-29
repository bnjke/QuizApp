package com.bnjke.quizapp;

public class Questions {

    String questions, ans1, ans2, ans3, ans4, correct;

    public Questions(String questions, String ans1, String ans2, String ans3, String ans4, String correct) {
        this.questions = questions;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.correct = correct;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
