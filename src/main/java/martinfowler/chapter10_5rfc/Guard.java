package martinfowler.chapter10_5rfc;

public class Guard {

    //3.修改调用者，将原本的第一调用动作替换成两个调用：先调用修改函数，然后调用查询函数
    void checkSecurity(String[] people) {
//        String found = findCriminalAndAlert(people);
        sendAlert(people); // 先修改
        String found = foundPerson(people); // 后查询
        someLaterCode(found);
    }

    private void someLaterCode(String found) {
        System.out.println("Do something!!!");
    }

    /**
     * 既有查询函数，又有修改函数。
     * 查询函数中，有返回值
     *
     * 2.逐一替换原函数内所有的return语句，改调用新建的查询函数
     *
     * 4.所有的调用者都替换完毕之后，将修改函数的返回值改成void
     *
     * 5.修改原函数名称
     *
     * 6.去除重复代码，运行Substitute Algorithm
     *
     * @param people
     * @return
     */
    void sendAlert(String[] people) {
       /* for (int i = 0; i < people.length; i++) {
            if(people[i].equals("Don")) {
                sendAlert();
//                return "Don";
//                return foundPerson(people);
                return;
            }
            if(people[i].equals("John")) {
                sendAlert();
//                return "John";
//                return foundPerson(people);
                return;
            }
        }*/
//        return foundPerson(people);
        if(!foundPerson(people).equals("")) {
            sendAlert();
        }
    }

    //1.新建一个查询函数，令他的返回值与原函数相同
    String foundPerson(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if(people[i].equals("Don")) {
                return "Don";
            }
            if(people[i].equals("John")) {
                return "John";
            }
        }
        return "";
    }

    private void sendAlert() {
        System.out.println("someone came in!!!");
    }

}
