package Object.Abstract;

/*
@author 黄佳豪
@create 2019-07-20-21:08
*/
public class Person {
}

interface StudyEnglish {
    void studyEnglish();
}
abstract class Student implements StudyEnglish{
    public abstract void study();
}

class Colledge extends Student {
    @Override
    public void study() {

    }

    @Override
    public void studyEnglish() {

    }
}

class MinddleSchoolStudent extends Student {
    @Override
    public void studyEnglish() {

    }

    @Override
    public void study() {

    }
}
abstract class Sporter implements StudyEnglish{
    public abstract void sport();
}

class BasketBaller extends Sporter {
    @Override
    public void studyEnglish() {

    }

    @Override
    public void sport() {

    }
}

class FootBaller extends Sporter {
    @Override
    public void studyEnglish() {

    }

    @Override
    public void sport() {

    }
}