package AbstractClassChallenge;

public class AbstractClassChallengeApp {
    public static void main(String[] args) {
        SearchTree tree = new SearchTree(null);

        String stringData = "Space Soul Power Time Mind Reality";
        String[] data = stringData.split(" ");
        for (String s : data) {
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("Power"));
        tree.traverse(tree.getRoot());
    }
}
