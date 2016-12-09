import java.io.File;
import java.util.List;
import java.util.ArrayList;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.dev.util.log.PrintWriterTreeLogger;
import com.google.gwt.dev.cfg.ResourceLoader;
import com.google.gwt.dev.cfg.ResourceLoaders;
import com.google.gwt.dev.cfg.ModuleDef;
import com.google.gwt.dev.cfg.ModuleDefLoader;
import com.google.gwt.dev.Compiler;
import com.google.gwt.dev.NullRebuildCache;
import com.google.gwt.dev.CompilerContext;
import com.google.gwt.dev.CompilerOptions;
import com.google.gwt.dev.CompilerOptionsImpl;

/** Command line. TODO Why bother to sub-class Compiler??? */
public class JccMain extends Compiler
{
  public static void main(String[] args)
  {
    TreeLogger logger = new PrintWriterTreeLogger();

    final CompilerOptions options = new CompilerOptionsImpl();

    String[] inherits = new String[0]; 

    System.out.println("Loading module...");

    ModuleDef moduleDef = null;

    //try {

      // Synthetic: Not associated with an XML manifest file.
/*      moduleDef = ModuleDefLoader.createSyntheticModule(logger, "aimadonna",
        inherits, true); */
      ResourceLoader fallbackResources = ResourceLoaders.forClassLoader(Thread.currentThread());

      List<File> moduleDirectories = new ArrayList<File>();
      moduleDirectories.add( new File("/opt/ailabs/jcc2/example/") );

      ResourceLoader resources = ResourceLoaders.forPathAndFallback(moduleDirectories, fallbackResources);

      moduleDef = new ModuleDef("madonna", resources, true, true);

      moduleDef.addSourcePackage("", new String[]{}, new String[]{},
        new String[]{}, true, true);

      moduleDef.normalize(logger);

System.out.println("DEBUG getAllSourceFiles " + moduleDef.getAllSourceFiles().length );

      /*List<File> moduleDirectories =
        new ArrayList<File>(){{
          new File("madonnalanddir");
      }};*/

      // @TODO Kill this
      //ResourceLoader fallbackResources = ResourceLoaders.forClassLoader(Thread.currentThread());

      //ResourceLoader resources = ResourceLoaders.forPathAndFallback(moduleDirectories, fallbackResources);

      //moduleDef = ModuleDefLoader.loadFromResources(logger, "com.ailabs.madonna", resources, true);

      //ResourceOracle lazySourceOracle = moduleDef.getSourceResourceOracle();
      //lazySourceOracle.add("madonna.java");
    /*}
    catch (UnableToCompleteException e) {
      System.out.println("MODULEDEF LOAD FAILED " + e.toString() );  
      System.out.println("STACKTRACE: " + e.getStackTrace() );
    }*/

    System.out.println("jcc2 Hello World 32");

    CompilerContext compilerContext =
        new CompilerContext.Builder()
            .options(options)
            .minimalRebuildCache( new NullRebuildCache() )
            //.unitCache( this.getOrCreateUnitCache(logger, options) )
            .module(moduleDef)
            .build();

    System.out.println("COMPILED");
  }
}

