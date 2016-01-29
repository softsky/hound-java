package ph.hatch.hound;

import com.google.common.collect.Sets;
import org.junit.Test;
import spoon.Launcher;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jett on 1/28/16.
 */
public class DataClumpSnifferTest {

    @Test
    public void testFindParameterClumps() throws Exception {

        final String[] args = {
                //"-i", "/home/jett/citools/anti-patterns/src/main"
                "-i", "src/test/java/ph/hatch/antipatterns/sample"
                ,"-o", "target/spooned/"
        };

        final Launcher launcher = new Launcher();
        launcher.setArgs(args);
        launcher.run();

        final Factory factory = launcher.getFactory();

        Map<String, Set<String>> methodParams = new HashMap<String, Set<String>>();

        for(CtType<?> s : factory.Class().getAll()) {
            System.out.println(s.getSimpleName());
            for(CtMethod<?> method : s.getAllMethods()) {
                System.out.println("\t"+method.getSimpleName());

                Set<String> allParams = new HashSet<String>();

                for(CtParameter<?> params : method.getParameters()) {
                    allParams.add(params.getType()+":"+params.getSimpleName());
                    System.out.println("\t\t" + params.getType() + " : " + params.getSimpleName());
                }

                methodParams.put(method.getSimpleName(), allParams);


//                for(CtStatement statement : method.getBody().getStatements()) {
//
//                    if(statement instanceof CtLocalVariableImpl) {
//                        System.out.println("\t\t\tlocal var: " + ((CtLocalVariableImpl) statement).getSimpleName());
//                    }
            }
        }

            // todo: check if there is some overlap
        Set<String> intersection = Sets.intersection(methodParams.get("methodOne"), methodParams.get("methodTwo"));

        System.out.println("done!");
    }
}
