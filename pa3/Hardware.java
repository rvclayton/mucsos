// Operating Systems, Spring 2015


/**
   The Hardware interface defines what the hardware looks like to the operating
   system.

   For the most part, hardware looks like primary store with extra types,
   methods, and classes defined for convenience (the extra types, methods, and
   classes are not necessarily related to primary store).

   This interface is implemented by code in the simulator jar file.  Your
   operating-system code does not implment this interface. Your
   operating-system code makes use of the types, methods and classes defined in
   this interface.  This file should not be modified; changes made to this file
   are ignored by the turn-in system.
 */


interface Hardware
extends PrimaryStore {

  /**
     Addresses of interest within primary store.  Not all constants defined are
     addresses (some are sizes), and deviceTop is not a valid address.
   */

  static final class
  Address {
    static final int

      systemBase = 0,
      systemSize = 1024,
      systemTop = systemBase + systemSize,

      userBase = systemTop,
      userSize = 1024,
      userTop = userBase + userSize,

      deviceBase = userTop,
      deviceSize = 1024,
      deviceTop = deviceBase + deviceSize,

      storageTop = deviceTop,

    /** 
       The register set lives in the first few addresses in primary storage.
    */

      // The number of registers available.

      registerSetSize = 16,

      // One past the address of the last (rightmost, highest-address) register
      // in the register set.

      nextRegister = systemBase + registerSetSize,

      baseRegister = nextRegister - 1,
      topRegister = baseRegister - 1,
      IARegister = topRegister - 1,
      PCRegister = IARegister - 1,
      PSRegister = PCRegister - 1,
    

    /**
       The simulator puts an idle program in the kernel so the os has something
    */

      // The address of the first word of the idle program.

      idleStart = nextRegister,

      // The address one past the last word of the idle program.

      idleEnd = idleStart + 1,


    /**
       Device-space addresses.
    */

      clockRegister = deviceBase,
      countdownRegister = clockRegister + 1,
      haltRegister = countdownRegister + 1,
      diskCommandRegister = haltRegister + 1,
      diskBlockRegister = diskCommandRegister + 1,
      diskAddressRegister = diskBlockRegister + 1,
      diskStatusRegister = diskAddressRegister + 1;
    }


  /**
     Define disk characteristics.
   */

  
  static final class 
  Disk {
    static final int

      /**
	 The number of words in a disk block.
      */

      blockSize = 32,

      /**
	 The number of blocks in a disk.
      */

      blockCount = 32,

      /**
	 The command to read data from the disk to storage.
       */

      readCommand = 1,

      /**
	 The command to write data from storage to the disk.
       */

      writeCommand = 2;
    }


  /**
     The types of interrupts that can be raised by the hardware.
   */

  enum 
  Interrupt {

    /**
       Raised when the countdown register decreases from 1 to 0.  Writing a
       zero to the countdown register does not raise this interrupt.
     */

    countdown,


    /**
       Raised when the disk has finished executing its most recent operation.
     */

    disk,


    /**
       Raised when user code attempts to execute an unrecognized instruction.
     */

    illegalInstruction,


    /**
       Raised when user code attempts to read or write an address outside its
       assigned address space.
     */

    invalidAddress,


    /**
       Raised on system power-up.
     */

    reboot,


    /**
       Raised when user code executes a trap instruction.
     */

    systemCall
    }


  /**
     Possible responses to commands for various hardware components.
   */

  final static class 
  Status {

    /**
       The status codes returned by various hardware components.
     */

    static final int 
      badAddress     = 1,
      badBlockNumber = 2,
      badCommand     = 3,
      badPid         = 6,
      noResource     = 9,
      ok             = 10
      ;


    /**
       Convert a status value to a string.

       @param s The status value of interest.

       @returns A string representation of the given status value.
     */

    static String
    toString(int s) {
      switch (s) {
	case badAddress    : return "bad address";
	case badBlockNumber: return "bad block number";
	case badCommand    : return "bad command";
	case badPid        : return "bad PID";
	case noResource    : return "no resource";
	case ok            : return "ok";
	default            : SystemSim.panic("Unknown status value:  " + s);
        }
      return "";
      }
    }
  }


// $Log: Hardware.java,v $
// Revision 1.6  2015/02/22 19:45:51  rclayton
// define the csin and csout system-call values.
//
// Revision 1.5  2015/02/06 19:09:11  rclayton
// amplify on the implementor's responsibility.
//
// Revision 1.4  2012/02/19 03:03:52  rclayton
// Renumber the status codes.
//
// Revision 1.3  2012/02/16 05:22:24  rclayton
// Convert status values to strings.
//
// Revision 1.2  2012/02/12 20:36:49  rclayton
// Disks are too big; change Disk.blockCount to make the disk smaller.
//
// Revision 1.1  2012/02/10 10:10:36  rclayton
// Define storageTop
//
