Brief Overview of Project: We are given a csv file containing several lines in which each line contains Type(CD, Vinyl, Tape), Title(Name of the track), Price, Year, and Genre in that specific order. We are then given the task of making an inventory management system for a media product shop. To do this we created a singleton class in which we are able to retrieve any lines(or objects) based on if they are a vinyl, CD, or Tape. We can also take all the lines and make objects containing all the fields given and add them to our inventory. We can update the price of a track and we can also add or remove tracks as well. Also we can get certain media products below a certain price and. At the very end pulling it all together we can call saveStock() to save the updated inventory back to the CSV file and print all of the media products if we choose to do so. For this assignment, we worked together equally splitting up the tasks given and each completing a set of functions to make sure they all work properly.

Functions we wrote:
Abhinav P: getVinylRecordList(), getCDRecordsList(), getTapeRecordList()
Aditya R: getInstance(), initializeStock()
Matthew R: updateItemPrice(), addItem, removeItem()
Nitin C: saveStock(), getMediaProductBelowPrice(), printListOfMediaProduct()

The Main included also includes all of the code that we used to test our code to see if they function properly. 

To run the program:
1) git clone https://github.com/aditya-ramki04/A-Homework_3.git
2) Go into Eclipse and import the file: A-Homework_3
3) You can then click on the program and run it!
