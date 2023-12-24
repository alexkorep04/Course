package edu.project3.resolvers;

import edu.project3.arguments.Argument;
import edu.project3.arguments.TypeOfArg;
import java.util.ArrayList;
import java.util.List;

public class ArgumentLineResolver {
    private int position;
    private final static String NOT_CORRECT = "Not correct arguments!";
    private final static String TO = "--to";
    private final static String FROM = "--from";
    private final static String FORMAT = "--format";

    private Argument getPath(List<String> arguments) {
        if (arguments.size() < 2 || !"--path".equals(arguments.get(0))) {
            throw new RuntimeException(NOT_CORRECT);
        }
        int i = 1;
        position = i;
        List<String> pathes = new ArrayList<>();
        while (i < arguments.size() && !isArgument(arguments.get(i))) {
            pathes.add(arguments.get(i));
            i++;
            position = i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: pathes) {
            stringBuilder.append(s + " ");
        }
        String s = stringBuilder.toString().trim();
        return new Argument(s, TypeOfArg.PATH);
    }

    private boolean isArgument(String part) {
        if (TO.equals(part) || FROM.equals(part) || FORMAT.equals(part)) {
            return true;
        }
        return false;
    }

    public List<Argument> getArguments(List<String> unResolvedArguments) {
        List<Argument> arguments = new ArrayList<>();
        arguments.add(getPath(unResolvedArguments));
        int i = position;
        for (; i < unResolvedArguments.size() - 1; i++) {
            if (isArgument(unResolvedArguments.get(i)) && isArgument(unResolvedArguments.get(i - 1))) {
                throw new RuntimeException(NOT_CORRECT);
            }
            String cur = unResolvedArguments.get(i);
            if (isArgument(cur) && TO.equals(cur)) {
                    arguments.add(new Argument(unResolvedArguments.get(i + 1), TypeOfArg.TO));
                    i++;
            } else if (isArgument(cur) && FROM.equals(cur)) {
                    arguments.add(new Argument(unResolvedArguments.get(i + 1), TypeOfArg.FROM));
                    i++;
            } else if (isArgument(cur) && FORMAT.equals(cur)) {
                    arguments.add(new Argument(unResolvedArguments.get(i + 1), TypeOfArg.FORMAT));
                    i++;
            } else {
                throw new RuntimeException(NOT_CORRECT);
            }
        }
        return arguments;
    }
}
