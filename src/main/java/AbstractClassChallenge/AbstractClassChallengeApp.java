package AbstractClassChallenge;

public class AbstractClassChallengeApp {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList(null);
//        linkedList.traverse(linkedList.getRoot());

        String stringData = "Space Soul Power Time Mind Reality";
        String[] data = stringData.split(" ");
        for (String s : data) {
            linkedList.addItem(new Node(s));
        }

        linkedList.traverse(linkedList.getRoot());
        linkedList.removeItem(new Node("Time"));
        linkedList.traverse(linkedList.getRoot());
    }
}
