package examenes.parcial_2020_2021.solucion;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.binarytree.LinkedBinaryTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuessWho {

    private BinaryTree<String> game;
    private List<Position<String>> pos;
    private Iterator<Position<String>> iterator;

    public void loadGame(String path) {
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            int lineCount = 1;
            String line = null;
            game = new LinkedBinaryTree<>();
            pos = new ArrayList<>();
            pos.add(null);
            while ((line = bf.readLine()) != null) {
                if (!line.equals("NADA")) {
                    if (lineCount == 1) {
                        pos.add(game.addRoot(line));
                    } else {
                        int posParent = lineCount / 2;
                        Position<String> parent = pos.get(posParent);
                        if (lineCount == posParent * 2) {
                            pos.add(game.insertLeft(parent, line));
                        } else {
                            pos.add(game.insertRight(parent, line));
                        }
                    }
                } else {
                    pos.add(null);
                }
                lineCount++;
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Initializes an iterator through the game, starting at
    the first question
     */
    public void resetIterator() {
        iterator = game.iterator();
    }

    /*
    Returns true if there are more question to be read
    by the iterator, or false otherwise
     */
    public boolean hasMoreQuestions() {
        return iterator.hasNext();
    }

    /*
    Returns the next question to be read from the game
     */
    public String nextQuestion() {
        return iterator.next().getElement();
    }

    /*
    Returns the maximum number of questions (without including the response)
    that can be performed in the game
     */
    public int longestGame() {
        return depthRec(game.root(), 0);
//        return depthRec(game.root(), 0)-1;
    }


    private int depthRec(Position<String> node, int currDepth) {
        if (game.isLeaf(node)) {
            return currDepth+1;
        } else {
            int max = -1;
            for (Position<String> child : game.children(node)) {
                max = Math.max(max, depthRec(child, currDepth+1));
            }
            return max;
        }
    }

    /*
    Returns the number of responses stored in this game
     */
    public int responses() {
        int leaf = 0;
        for (Position<String> p : game) {
            if (game.isLeaf(p)) {
                leaf++;
            }
        }
        return leaf;
    }

    public String solve(String path) {
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = null;
            Position<String> traversal = game.root();
            while ((line = bf.readLine()) != null) {
                if (line.equals("SI") && game.hasLeft(traversal)) {
                    traversal = game.left(traversal);
                } else if (line.equals("NO") && game.hasRight(traversal)) {
                    traversal = game.right(traversal);
                } else {
                    return "INCORRECTO";
                }
            }
            return traversal.getElement();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "INCORRECTO";
    }

    public String showGame() {
        StringBuilder stb = new StringBuilder();
        showGameRec(game.root(), stb, 0);
        return stb.toString();
    }

    private void showGameRec(Position<String> p, StringBuilder stb, int level) {
        for (int i = 0; i < level; i++) {
            stb.append("\t");
        }
        stb.append(p.getElement()).append("\n");
        for (Position<String> child : game.children(p)) {
            showGameRec(child, stb, level+1);
        }
    }

    
}
