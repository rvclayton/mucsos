// Operating Systems, Spring 2015.

/**
   The PrimaryStore interface defines, in part, what primary store looks like
   to the operating system (the Hardware interface defines more primary-store
   aspects).

   This interface is implemented by code in the simulator jar file.  Your
   operating-system code does not implment this interface.  Your
   operating-system code makes use of the methods defined in this interface.
   This file should not be modified; changes made to this file are ignored by
   the turn-in system.
 */


interface 
PrimaryStore {

  /**
     Fetch a word from primary store or die.  If an error occurs during the
     fetch, print an error message and exit the simulator.

     @param addr The address from which to fetch.

     @returns The value fetched.
   */

  int fetch(int addr);


  /**
     Store a word in primary store or die.  If an error occurs during the
     store, print an error message and exit the simulator.

     @param addr The address to which the word is stored.

     @param word The word to store.
   */

  void store(int addr, int word);
  }


// $Log: PrimaryStore.java,v $
// Revision 1.3  2015/02/06 19:08:10  rclayton
// amplify on the implementor's responsibility
//
// Revision 1.2  2015/02/05 12:33:42  rclayton
// documentation
//
// Revision 1.1  2012/02/12 20:37:03  rclayton
// Initial revision
//