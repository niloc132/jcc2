import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.ArrayList;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.dev.util.log.PrintWriterTreeLogger;
import com.google.gwt.dev.cfg.ResourceLoader;
import com.google.gwt.dev.cfg.ResourceLoaders;
import com.google.gwt.dev.cfg.ModuleDef;
import com.google.gwt.dev.cfg.ModuleDefLoader;
import com.google.gwt.dev.cfg.BindingProperty;
import com.google.gwt.dev.cfg.ConditionNone;
import com.google.gwt.dev.Compiler;
import com.google.gwt.dev.NullRebuildCache;
import com.google.gwt.dev.CompilePerms;
import com.google.gwt.dev.CompilerContext;
import com.google.gwt.dev.CompilerOptions;
import com.google.gwt.dev.CompilerOptionsImpl;
import com.google.gwt.dev.Precompilation;
import com.google.gwt.dev.Precompile;
import com.google.gwt.dev.Permutation;
import com.google.gwt.dev.jjs.PermutationResult;
import com.google.gwt.dev.util.PersistenceBackedObject;



/** Don't ask why this is called class path when we are loading Java source units */
class JccResourceLoader implements ResourceLoader
{
  /**
   * Returns the URLs that will be searched in order for files.
   */
  public List<URL> getClassPath()
  {
    List<URL> classPath = new ArrayList<URL>();
    try {
      classPath.add( new URL("file:/opt/ailabs/jcc2/example/") );
    }
    catch(MalformedURLException e) {
      System.out.println("MalformedURLException: " + e);
    }
    return classPath;
  }

  /**
   * Returns a URL that may be used to load the resource, or null if the
   * resource can't be found.
   *
   * <p> (The API is the same as {@link ClassLoader#getResource(String)}.) </p>
   */
  public URL getResource(String resourceName)
  {
System.out.println("JccResourceLoader.getResource(): asked to load " + resourceName);
    return null;
  }
}

/** Command line. TODO Why bother to sub-class Compiler??? */
public class JccMain extends Compiler
{
  public static void main(String[] args)
  {
    TreeLogger logger = new PrintWriterTreeLogger();

    final CompilerOptions options = new CompilerOptionsImpl();
 
    options.setRunAsyncEnabled(false);

    System.out.println("Loading module...");

    ModuleDef moduleDef = null;

  try {

      // Synthetic: Not associated with an XML manifest file.
//      String[] inherits = new String[]{"com.google.gwt.core.Core"};
//      ModuleDef moduleDefCore = ModuleDefLoader.createSyntheticModule(logger, "ailoadcore",
//        inherits, true);

      // Synthetic: Not associated with an XML manifest file.
/*      moduleDef = ModuleDefLoader.createSyntheticModule(logger, "aimadonna",
        inherits, true); */

      ResourceLoader resources = new JccResourceLoader();

      moduleDef = new ModuleDef("madonna", resources, true, true);

// Would normally be set in XML
BindingProperty stackModeProp = new BindingProperty("compiler.stackMode");
stackModeProp.addDefinedValue(new ConditionNone(), "STRIP");
moduleDef.getProperties().addBindingProperty(stackModeProp);
//"strip"

      moduleDef.addSourcePackage("", new String[]{}, new String[]{},
        new String[]{}, true, true);

      // Main has entrypoint.
      moduleDef.addEntryPointTypeName("madonna.Madonna");

      moduleDef.normalize(logger);

System.out.println("DEBUG getAllSourceFiles " + moduleDef.getAllSourceFiles().length );
System.out.println("DEBUG getAllSourceFiles " + moduleDef.getAllSourceFiles()[0] );

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

    System.out.println("jcc2 Hello World 32");

    CompilerContext compilerContext =
        new CompilerContext.Builder()
            .options(options)
            .minimalRebuildCache( new NullRebuildCache() )
            //.unitCache( this.getOrCreateUnitCache(logger, options) )
            .module(moduleDef)
            .build();

      String moduleName = moduleDef.getCanonicalName();

      System.out.println("Canonical Module Name: " + moduleName);

      //boolean validated = Precompile.validate(logger, compilerContext);
      // Precompilation, which diagnoses problems with modules.
      Precompilation precompilation = Precompile.precompile(logger, compilerContext);

      if (precompilation == null) {
        System.out.println("JccMain: Precompilation failed, cannot compile!");
        System.exit(0);
        return;
      }

      System.out.println("PRECOMPILE SUCCESS!" + (precompilation != null) );


// Compilation
System.out.println("COMPILING...");
			Permutation[] allPerms = precompilation.getPermutations();

File workDir = new File("/opt/ailabs/jcc2/work");

			List<PersistenceBackedObject<PermutationResult>> resultFiles = CompilePerms.makeResultFiles(workDir, allPerms, options);
			CompilePerms.compile(logger, compilerContext, precompilation, allPerms, options.getLocalWorkers(), resultFiles);

//			ArtifactSet generatedArtifacts = precompilation.getGeneratedArtifacts();
//			PrecompileTaskOptions precompileOptions = precompilation.getUnifiedAst().getOptions();

System.out.println("COMPILED!");

System.out.println("LINKING...");


        }
    catch (UnableToCompleteException e) {
      System.out.println("MODULEDEF LOAD FAILED " + e.toString() );  
      System.out.println("STACKTRACE: " + e.getStackTrace() );
    }
  }
}

