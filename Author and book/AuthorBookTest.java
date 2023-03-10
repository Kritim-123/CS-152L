/**
 * Tests Book and Author classes.
 *
 * NOTE: This code will not compile until you have created and
 * implemented the Book and Author classes described in the
 * assignment.
 */
public class AuthorBookTest {

    public static void main(String[] args) {
        Book [] allTheBooks = new Book[30];
        int score = 4; int tScore = 0;

        // Test the constructors to make sure they compile and run.

        System.out.println( "Attempting constructors:" );

        Author a1 = new Author("Ballard", "J.G.");
        Author a2 = new Author("Eggers", "Dave");
        Author a3 = new Author("Catton", "Eleanor");
        Author a4 = new Author("Adler", "Renata");

        System.out.println( "  - Author constructors seem functional:  2/2" );

        allTheBooks[0] = new Book();
        allTheBooks[1] = new Book( "The Circle" );
        allTheBooks[2] = new Book( "The Luminaries", a3 );
        allTheBooks[3] = new Book();
        allTheBooks[4] = new Book( "Pitch Dark" );
        allTheBooks[5] = new Book( "Speedboat" );
        allTheBooks[6] = new Book();
        allTheBooks[7] = new Book( "The Dissident Gardens" );

        System.out.println( "  - Book constructors seem functional:    2/2" );

        // Setters/getters

        System.out.println( "\nAttempting simple getters/setters:" );

        allTheBooks[0].setTitle( "The Complete Stories" );
        if( "The Complete Stories".equals( allTheBooks[0].getTitle() ) ) { tScore++; }
        if( "The Circle".equals( allTheBooks[1].getTitle() ) ) { tScore++; }

        System.out.println( "  - getTitle/setTitle:                  " + tScore + "/2" );
        score += tScore; tScore = 0;

        allTheBooks[0].setAuthor( a1 );
        allTheBooks[1].setAuthor( a2 );
        if( a1 == allTheBooks[0].getAuthor() ) { tScore++; }
        if( a3 == allTheBooks[2].getAuthor() ) { tScore++; }

        System.out.println( "  - getAuthor/setAuthor:                " + tScore + "/2" );
        score += tScore; tScore = 0;

        allTheBooks[0].setPublicationYear( 2010 );
        allTheBooks[1].setPublicationYear( 2013 );
        if( 2010 == allTheBooks[0].getPublicationYear() ) { tScore++; }
        if( 2013 == allTheBooks[1].getPublicationYear() ) { tScore++; }

        System.out.println( "  - get/setPublicationYear:             " + tScore + "/2" );
        score += tScore; tScore = 0;

        allTheBooks[1].setISBN( "9780385351393" );
        allTheBooks[2].setISBN( "9780316074315" );
        if( "9780385351393" == allTheBooks[1].getISBN() ) { tScore++; }
        if( "9780316074315" == allTheBooks[2].getISBN() ) { tScore++; }

        System.out.println( "  - get/setISBN:                        " + tScore + "/2" );
        score += tScore; tScore = 0;


        a4.setLifespan( 1938 );
        a2.setLifespan( 1970 );
        a1.setLifespan( 1930, 2009 );
        if( 2009 == a1.getDeathYear() ) { tScore++; }
        if( 1930 == a1.getBirthYear() ) { tScore++; }
        if( 1970 == a2.getBirthYear() ) { tScore++; }
        if( AuthorBookConstants.UNSPECIFIED_YEAR == a2.getDeathYear() ) { tScore++; }

        System.out.println( "  - getBirth/getDeath/setLifespan:      " + tScore + "/4" );
        score += tScore; tScore = 0;

        // Were the default constants correctly used?

        System.out.println( "\nAttempting un-set values register correctly:" );

        if( AuthorBookConstants.UNSPECIFIED_YEAR == allTheBooks[2].getPublicationYear() ) { tScore++; }
        if( AuthorBookConstants.UNSPECIFIED_AUTHOR == allTheBooks[3].getAuthor() ) { tScore++; }
        if( AuthorBookConstants.UNSPECIFIED_AUTHOR == allTheBooks[4].getAuthor() ) { tScore++; }
        if( AuthorBookConstants.UNSPECIFIED_TITLE == allTheBooks[3].getTitle() ) { tScore++; }
        if( AuthorBookConstants.UNSPECIFIED_ISBN == allTheBooks[0].getISBN() ) { tScore++; }

        System.out.println( "  - un-set values:  " + tScore + "/5" );
        score += tScore; tScore = 0;


        // Try to set bad values and see if it correctly rejects them.

        System.out.println( "\nAttempting bad-value setters:" );

        allTheBooks[0].setPublicationYear( 2030 );
        if( 2010 == allTheBooks[0].getPublicationYear() ) { tScore++; }
        allTheBooks[0].setPublicationYear( 2025 );
        if( 2010 == allTheBooks[0].getPublicationYear() ) { tScore++; }
        allTheBooks[0].setPublicationYear( 0 );
        if( 2010 == allTheBooks[0].getPublicationYear() ) { tScore++; }
        System.out.println( "  - invalid publication year:             " + tScore + "/3" );
        score += tScore; tScore = 0;

        allTheBooks[0].setTitle( "" );
        if( "The Complete Stories" == allTheBooks[0].getTitle() ) { tScore+=2; }
        System.out.println( "  - empty title rejected:                 " + tScore + "/2" );
        score += tScore; tScore = 0;

        allTheBooks[0].setISBN( "38741" );
        if( AuthorBookConstants.UNSPECIFIED_ISBN == allTheBooks[0].getISBN() ) { tScore++; }
        allTheBooks[0].setISBN( "123456789123456789123456789" );
        if( AuthorBookConstants.UNSPECIFIED_ISBN == allTheBooks[0].getISBN() ) { tScore++; }
        System.out.println( "  - ISBN of incorrect length rejected:    " + tScore + "/2" );
        score += tScore; tScore = 0;

        a1.setLifespan( -3000 );
        if( 1930 == a1.getBirthYear() ) { tScore++; }
        a1.setLifespan( -2000 );
        if( 1930 == a1.getBirthYear() ) { tScore++; }
        System.out.println( "  - year of birth in super past rejected: " + tScore + "/2" );
        score += tScore; tScore = 0;

        a1.setLifespan( 1930, 1919 );
        if( 2009 == a1.getDeathYear() ) { tScore+=2; }
        System.out.println( "  - year of death before birth rejected:  " + tScore + "/2" );
        score += tScore; tScore = 0;

        // Check if stuff is the same

        System.out.println( "\nComparisons:" );

        Author ax1 = new Author(new String("Catton"), new String("Eleanor"));
        Author ax2 = new Author(new String("Catton"), "J");
        Author ax3 = new Author("C", new String("Eleanor"));

        Author ax4 = new Author(new String("Catton"), "E");
        Author ax5 = new Author(new String("Catton"), new String("Elizabeth"));

        if( a3.hasSameName(ax1) ) { tScore++; }

        if( !a3.hasSameName(ax2) ) { tScore++; }

        if( !a3.hasSameName(ax3) ) { tScore++; }

        if( !a3.hasSameName(ax5) ) { tScore++; }


        System.out.println( "  - author comparison tests:          " + tScore + "/4" );
        score += tScore; tScore = 0;

        if( a3.hasSameName(ax4) ) { tScore+=2; }
        if( ax4.hasSameName(a3) ) { tScore+=2; }
        if( ax4.hasSameName(ax5) ) { tScore+=1; }
        System.out.println( "  - *bonus* author comparison tests:  " + tScore + "/5" );
        score += tScore; tScore = 0;


        allTheBooks[4].setAuthor( a4 );
        allTheBooks[5].setAuthor( a4 );
        if( allTheBooks[4].hasSameAuthor( allTheBooks[5] ) ) { tScore++; }
        if( !allTheBooks[4].hasSameAuthor( allTheBooks[2] ) ) { tScore++; }
        System.out.println( "  - sameAuthor (across two books):    " + tScore + "/2" );
        score += tScore; tScore = 0;

        allTheBooks[6].setISBN( "9780316074315" );
        if( !allTheBooks[6].isSame( allTheBooks[5] ) ) { tScore++; }
        if( allTheBooks[6].isSame( allTheBooks[2] ) ) { tScore++; }
        System.out.println( "  - comparing two books:              " + tScore + "/2" );
        score += tScore; tScore = 0;

        // Check string representations

        System.out.println( "\nString representations of authors and books:" );
        String x1 = "Adler, Renata";
        String x2 = "Ballard, J.G.";
        if( x2.equals(allTheBooks[0].getAuthor().toString()) ) { tScore++; }
        if( x1.equals(allTheBooks[4].getAuthor().toString()) ) { tScore++; }
        System.out.println( "  - string for an author's name:         " + tScore + "/2" );
        score += tScore; tScore = 0;

        String x3 = "Catton, Eleanor";
        String x4 = "Ballard, J.G. (1930-2009)";
        String x5 = "Eggers, Dave (born 1970)";
        if( x3.equals(allTheBooks[2].getAuthor().getLongString()) ) { tScore++; }
        if( x4.equals(allTheBooks[0].getAuthor().getLongString()) ) { tScore++; }
        if( x5.equals(allTheBooks[1].getAuthor().getLongString()) ) { tScore++; }
        System.out.println( "  - string for an author's name + info:  " + tScore + "/3" );
        score += tScore; tScore = 0;

        String b1 = "The Circle (2013). Eggers, Dave.";
        String b2 = "The Luminaries. Catton, Eleanor.";
        String b3 = "The Dissident Gardens.";
        if( b1.equals(allTheBooks[1].toString()) ) { tScore++; }
        if( b2.equals(allTheBooks[2].toString()) ) { tScore+=2; }
        if( b3.equals(allTheBooks[7].toString()) ) { tScore+=2; }
        System.out.println( "  - string for a book's name + info:     " + tScore + "/5" );
        score += tScore; tScore = 0;


        System.out.println( "\nOverall Score: " + score + "/50  \n   (can be up to 55 with bonus)" );
    }
}
