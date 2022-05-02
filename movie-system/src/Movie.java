public class Movie {
    private String number;
    private String movieName;
    private String movieTime;
    private int moviePrice;

        public Movie (){

        }

    public Movie(String number,String movieName,String movieTime,int moviePrice){
        this.number=number;
        this.movieName=movieName;
        this.movieTime=movieTime;
        this.moviePrice=moviePrice;
    }

    public void setNumber(String number){
        this.number=number;
    }
    public void setMovieName(String movieName){
        this.movieName=movieName;
    }
    public void setMovieTime(String movieTime){
        this.movieTime =movieTime;
    }
    public void setMoviePrice(int moviePrice){
        this.moviePrice=moviePrice;
    }
    public String getNumber() {
        return number;
    }
    public String getMovieName(){
        return movieName;
    }
    public String getMovieTime(){
        return movieTime;
    }
    public int getMoviePrice(){
        return moviePrice;
    }


        @Override
        public String toString() {
            return
                number+"   "+
                movieName+"          "+
                movieTime+"          "+
                moviePrice;
        }
}
