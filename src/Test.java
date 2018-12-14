import java.util.Scanner;

public class Test
{
    private LinkedBinaryTreeNode root;

    public void newMain() {
        Scanner input = new Scanner(System.in);
        System.out.println("Think of an animal.");
        if(root.getData() == null)
        {
            setUp();
//            guess();
        }




    }

    private void setUp()
    {
        root.setData("Elephant");
    }
    private void guess(char letter, LinkedBinaryTreeNode node)
    {
        if(letter == 'n')
        {
            if(node.getLeft() != null)
            {

            }
        }
    }

    public void answerNo(LinkedBinaryTreeNode node)
    {
        System.out.print(" ");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.newMain();
    }
}