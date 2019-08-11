package Collection.SetAPI;

import java.util.HashSet;
import java.util.Iterator;

/*
一、已知Music类，里面有歌曲名和时长，并重写了hashCode和equals方法。
现要求使用HashSet添加2个Music对象，并遍历。显示时将歌曲名长度>3的截取前三位后面追加...
示例：歌曲名：亲爱的祖国。显示为：亲爱的...
其他不变
@author 黄佳豪
@create 2019-07-26-9:02
*/
public class Homework1 {
    public static void main(String[] args) {
        HashSet<Music> m = new HashSet<>();
        m.add(new Music("双抗建设路口", 124201));
        m.add(new Music("大家能够", 423101));
        m.add(new Music("歌声", 745801));
        m.add(new Music("二恶国士无双", 45401));
        Iterator<Music> i = m.iterator();
        while (i.hasNext()) {
            Music ms = i.next();
            String msName = ms.getName();
            String name;
            if (msName.length() > 3) {
                name = msName.substring(0, 3) + "...";
            } else {
                name = msName;
            }
            System.out.println("Music’s name is：" + name + " 时长：" + (float)(0.0001+ms.getTime()/1000/60)+"分");
        }
    }
}
@SuppressWarnings("all")
class Music {
    private String name;
    private int time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Music music = (Music) o;

        if (time != music.time) return false;
        return name != null ? name.equals(music.name) : music.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + time;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Music(String name, int time) {
        this.name = name;
        this.time = time;
    }
}