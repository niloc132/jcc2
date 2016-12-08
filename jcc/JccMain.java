import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.dev.util.log.PrintWriterTreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.dev.Compiler;
import com.google.gwt.dev.CompilerOptions;
import com.google.gwt.dev.CompilerOptionsImpl;

/** Command line */
public class JccMain extends Compiler
{
  public static void main(String[] args)
  {
    TreeLogger logger = new PrintWriterTreeLogger();

    final CompilerOptions options = new CompilerOptionsImpl();
    System.out.println("jcc2 Hello World 1");

    try {
      boolean success = Compiler.compile(logger, options);
    }
    catch(UnableToCompleteException e) {
      System.out.println("ERROR " + e.toString() );
    }

    System.out.println("COMPILED");
  }
}

