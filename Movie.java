package a4;

import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
  private String title;
  private int releaseYear;
  ArrayList<String> genre = new ArrayList<String>(10);
  private int movieId; //optional
 
  public Movie (){
     title = " ";
     releaseYear = 0;
     genre.add(" ");
 } 
public Movie(String title, int releaseYear,String genre) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre.add(genre);
}
public Movie(String title, int releaseYear,ArrayList<String> g) {
        this.title = title;
        this.releaseYear = releaseYear;
        for (String strTemp : g) {
                this.genre.add(strTemp);
            }
}
public Movie(String title, int releaseYear,String genre1,String genre2) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre.add(genre1);
        this.genre.add(genre2);
        
}
public Movie(String title, int releaseYear,String genre1,String genre2,
        String genre3) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre.add(genre1);
        this.genre.add(genre2);
        this.genre.add(genre3);
}
public Movie(String title, int releaseYear,String genre1,String genre2,
        String genre3,String genre4) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre.add(genre1);
        this.genre.add(genre2);
        this.genre.add(genre3);
        this.genre.add(genre4);
}
public Movie(String title, int releaseYear,String genre1,String genre2,
        String genre3,String genre4,String genre5) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre.add(genre1);
        this.genre.add(genre2);
        this.genre.add(genre3);
        this.genre.add(genre4);
        this.genre.add(genre5);
}
public Movie(String title, int releaseYear,String genre1,String genre2,
        String genre3,String genre4,String genre5,String genre6) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre.add(genre1);
        this.genre.add(genre2);
        this.genre.add(genre3);
        this.genre.add(genre4);
        this.genre.add(genre5);
        this.genre.add(genre6);
}
public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear ;
    }

    public void setReleaseYear(int Artist) {
        this.releaseYear = Artist;
    }
    
public String toString() {
        return this.title + "(" + this.releaseYear + ")" + Arrays.toString(genre.toArray());
    }
public boolean equals(Movie c) {
		if( c.title.equals(title)&&(c.releaseYear == releaseYear))
			return true;			
		else
			return false;			
	}
}

