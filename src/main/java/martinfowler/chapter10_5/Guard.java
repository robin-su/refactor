package martinfowler.chapter10_5;

public class Guard {

    public void checkSecurity(String[] people) {
        String found = findCriminalAndAlert(people);
        someLaterCode(found);
    }

    private void someLaterCode(String found) {
        System.out.println("Do something!!!");
    }

    /**
     * 既有查询函数，又有修改函数。
     * 查询函数中，有返回值
     *
     * @param people
     * @return
     */
    public String findCriminalAndAlert(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if(people[i].equals("Don")) {
                sendAlert();
                return "Don";
            }
            if(people[i].equals("John")) {
                sendAlert();
                return "John";
            }
        }
        return "";
    }

    private void sendAlert() {
        System.out.println("someone came in!!!");
    }

}
