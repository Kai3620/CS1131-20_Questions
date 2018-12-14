import java.util.Scanner;

public class Test
{
    private LinkedBinaryTreeNode root;

    public void newMain() {
        Scanner input = new Scanner(System.in);
        if(root == null)
        {
            setUp();
            guess(root);
        }
        else
        {
            guess(root);
        }

    }

    private void setUp()
    {
        LinkedBinaryTreeNode temp = new LinkedBinaryTreeNode("Elephant");
        root = temp;
    }


    // Checks if the node has a child. If it does will display the question. If it doesn't it will guess the animal.
    private void guess(LinkedBinaryTreeNode node)
    {
        Scanner input = new Scanner(System.in);
        if(node.getLeft() != null && node.getRight() != null)
        {
            System.out.print(node.getData() + " ");
            String answer = input.next();
            if(answer.equals("y"))
            {
                guess((LinkedBinaryTreeNode)node.getRight());
            }
            else
                guess((LinkedBinaryTreeNode)node.getLeft());
        }
        else
        {
            System.out.print("Was the animal you were thinking of a(n) " + node.getData() + "? ");
            String answer = input.next();
            if(answer.equals("y"))
            {
                System.out.println("It's me Waluigi, and I have won!");
            }
            else
            {
                answerNo(node);
            }
        }
    }

    public void answerNo(LinkedBinaryTreeNode node)
    {
        Scanner input = new Scanner(System.in);
        if(node.getLeft() == null)
        {
            System.out.print("What was the animal? ");
            String animal = input.next();

            Scanner nesquick = new Scanner(System.in);
            System.out.print("What question separates a(n) " + animal + " from a(n) " + node.getData() + " ");
            String question = nesquick.nextLine();

            System.out.print("What is the correct answer for this animal? ");
            String answer = input.next();

            if(answer.equals("y"))
            {
                // Makes a new node that will have the new animal and then points it back to the current node.
                LinkedBinaryTreeNode temp = new LinkedBinaryTreeNode(animal);
                temp.setParent(node);
                node.setRight(temp);


                // Put the current data of the node into a new one and the resets the data of the current node to be the question.
                temp = new LinkedBinaryTreeNode(node.getData());
                node.setLeft(temp);
                node.setData(question);
                temp.setParent(node);
            }
            else
            {
                // Makes a new node that will have the new animal and then points it back to the current node.
                LinkedBinaryTreeNode temp = new LinkedBinaryTreeNode(animal);
                temp.setParent(node);
                node.setLeft(temp);


                // Put the current data of the node into a new one and then resets the data of the current node to be the question.
                temp = new LinkedBinaryTreeNode(node.getData());
                node.setRight(temp);
                node.setData(question);
                temp.setParent(node);
            }
        }
        newMain();
    }




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to play a game? ");
        String answer = input.next();
        if(answer.equals("y") || answer.equals("yes"))
        {
            Test test = new Test();
            test.newMain();
        }
        else
            System.out.println("Alright then. Maybe next time you'll actually want to play.");

    }
}