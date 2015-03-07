// Operating Systems, Spring 2015
//
// This file has been generated automatically.  Edits made to this file will be
// lost when next generated.

/**
   The OperatingSystem interface defines the characteristics of an operating
   system that are accessible to the hardware.

   The interface below describes the operating system in terms of a single
   method, the interrupt-handler method.  However, the hardware also expects
   any class implementing the OperatingSystem interface to also have a public
   constructor accepting a single parameter of type Hardware:

     <blockquote><pre>
       class OS
       implements OperatingSystem {

         // blah blah blah

         public OS(Hardware hw) {
	   // blah blah blah
           }

	 // blah blah blah

         void interrupt(Hardware.Interrupt it) {
	   // blah blah blah
	   }

	 // blah blah blah

         }
     </pre></blockquote>

   It is important that the constructor be public; the simulator can't
   recognize non-public constructors.

   The instance passed in as a parameter to the constructor is the instance of
   the hardware on which the operating system is running.

   Your operating-system code implments this interface as described above; this
   interface is not implemented by code in the simulator jar file.  This file
   should not be turned-in; the turn-in system ignores this file.
  */


interface
OperatingSystem {

  /**
     The system calls defined by the operating system.
   */

  final static class 
  SystemCall {


    /**
       A process indicate which system call it is making by storing one of
       these values in a register prior to raising the system-call interrupt.
     */

    static final int
      exit = 1;


    /**
       Convert a system-call value to a string.

       @param s The status value of interest.

       @returns A string representation of the given status value.
     */

    static String
    toString(int s) {
      switch (s) {
        case exit:  return "exit";
        default: return "[SystemCall.toString(" + s + ") unknown]";
        }
      }
    }


  /**
     Notify the operating system an interrupt has been raised.

     @param it The raised interrupt's type.
   */

  void interrupt(Hardware.Interrupt it);
  }


// $Log: $
