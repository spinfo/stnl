/**
 * @author Fabian Steeg
 * Created on 16.02.2006
 *
 * @version $Revision: 1.2 $
 *
 */
package de.uni_koeln.spinfo.strings.algo.tests;

import java.io.File;

import junit.framework.TestCase;
import de.uni_koeln.spinfo.strings.algo.Util;
import de.uni_koeln.spinfo.strings.algo.lca.LCA;
import de.uni_koeln.spinfo.strings.algo.suffixtrees.WordSuffixTree;

/**
 * Some runtime complexity tests, to verify linear growing runtime of tree
 * construction and {@link LCA} preprocessing
 * 
 * @author Fabian Steeg (fsteeg)
 */
public class TestWordSuffixTreeComplexity extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test for {@link WordSuffixTree}
     */
    public void testConstructionRuntime() {

        // constructTree(Util.getText(new File("texts/small-text.txt")), false);
        // constructTree(Util.getText(new File("texts/small-text.txt")), true);
        //
        // constructTree(Util.getText(new File("texts/text1.txt")), false);
        // constructTree(Util.getText(new File("texts/text1.txt")), true);
        //
        // constructTree(Util.getText(new File("texts/text2.txt")), false);
        // constructTree(Util.getText(new File("texts/text2.txt")), true);
        //
        // constructTree(Util.getText(new File("texts/text3.txt")), false);
        // constructTree(Util.getText(new File("texts/text3.txt")), true);
        //
        // constructTree(Util.getText(new File("texts/text4.txt")), false);
        // constructTree(Util.getText(new File("texts/text4.txt")), true);
        //
        // constructTree(Util.getText(new File("texts/text5.txt")), false);
        // constructTree(Util.getText(new File("texts/text5.txt")), true);
        //
        // constructTree(Util.getText(new File("texts/text6.txt")), false);
        // constructTree(Util.getText(new File("texts/text6.txt")), true);
        //
        // constructTree(Util.getText(new File("texts/text7.txt")), false);
        // constructTree(Util.getText(new File("texts/text7.txt")), true);
        //
        // constructTree(Util.getText(new File("texts/text8.txt")), false);
        // constructTree(Util.getText(new File("texts/text8.txt")), true);

        // these take longer:
        // constructTree(Util.getText(new File("texts/faust-1-de.txt")), false);
        // constructTree(Util.getText(new File("texts/klsgh10.txt")), false);
        // constructTree(Util.getText(new File("texts/klsgh10.txt")), true);
        constructTree(Util.getText(new File("texts/wrnpc11.txt")), false);
        // constructTree(Util.getText(new File("texts/wrnpc11.txt")), true);

    }

    private void constructTree(String text, boolean reverse) {

        long start;
        long current;
        String[] in = text.split("[^a-zA-Z0-9\\$]");
        start = System.currentTimeMillis();
        WordSuffixTree tree = new WordSuffixTree(text, reverse, true, null);
        current = System.currentTimeMillis();
        System.out.print(in.length + " Tokens, " + text.length() + " Chars, "
                + (current - start) + " ms. ");
        start = System.currentTimeMillis();
        tree.exportDot("output.dot");
        current = System.currentTimeMillis();
        System.out.print("Output: ");
        System.out.print((current - start) + " ms.\n");
    }
}