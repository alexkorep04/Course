package edu.project3.launchers;

import edu.project3.arguments.Argument;
import edu.project3.arguments.TypeOfArg;
import edu.project3.collectors.BaseInformation;
import edu.project3.collectors.CodeResponses;
import edu.project3.collectors.MostPopularDate;
import edu.project3.collectors.MostPopularIPAddresses;
import edu.project3.collectors.MostPopularResources;
import edu.project3.models.FormatType;
import edu.project3.models.Table;
import edu.project3.parsers.LogParser;
import edu.project3.printers.Adoc;
import edu.project3.printers.DefaultPrinter;
import edu.project3.printers.Markdown;
import edu.project3.resolvers.ArgumentLineResolver;
import edu.project3.sources.FileSource;
import edu.project3.sources.URLSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Launcher {
    private List<Argument> arguments;
    private FormatType formatType;
    private String from;
    private String to;
    DefaultPrinter printer;
    BaseInformation baseInformation;
    CodeResponses codeResponses;
    MostPopularResources mostPopularResources;
    MostPopularIPAddresses mostPopularIPAddresses;
    MostPopularDate mostPopularDate;

    public Launcher(String[] argument) {
        this.arguments = new ArgumentLineResolver().getArguments(Arrays.stream(argument).toList());
        formatType = FormatType.MARKDOWN;
        baseInformation = new BaseInformation();
        codeResponses = new CodeResponses();
        mostPopularResources = new MostPopularResources();
        mostPopularIPAddresses = new MostPopularIPAddresses();
        mostPopularDate = new MostPopularDate();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void start() {
        for (int i = 0; i < arguments.size(); i++) {
            if (arguments.get(i).type() == TypeOfArg.FROM) {
                from = arguments.get(i).dimension();
            } else if (arguments.get(i).type() == TypeOfArg.TO) {
                to = arguments.get(i).dimension();
            } else if (arguments.get(i).type() == TypeOfArg.FORMAT && "adoc".equals(arguments.get(i).dimension())) {
                formatType = FormatType.ADOC;
            }
        }
        List<String> arrayList = new ArrayList<>();
        String[] paths = arguments.get(0).dimension().split(" ");
        for (String path : paths) {
            if (path.startsWith("http")) {
                arrayList.addAll(new URLSource().getLogsByURL(path));
            } else {
                arrayList.addAll(new FileSource().getLogsFromFile(path));
            }
        }
        if (formatType.equals(FormatType.ADOC)) {
            printer = new Adoc();
        } else {
            printer = new Markdown();
        }
        Table baseInfo = baseInformation.collectBaseInfo(from,
            to,
            Arrays.stream(paths).toList(),
            arrayList.stream().map(LogParser::parseLog).collect(
                Collectors.toList())
        );
        System.out.println(printer.printTable(baseInfo));
        Table codeInfo = codeResponses.collectResponseCodes(from, to,
            arrayList.stream().map(LogParser::parseLog).collect(
                Collectors.toList())
        );
        System.out.println(printer.printTable(codeInfo));
        Table resourcesInfo = mostPopularResources.collectInformationAboutMostPopularResources(from, to,
            arrayList.stream().map(LogParser::parseLog).collect(
                Collectors.toList())
        );
        System.out.println(printer.printTable(resourcesInfo));
        Table ipInfo = mostPopularIPAddresses.collectInformationAboutMostPopularIPAddresses(from, to,
            arrayList.stream().map(LogParser::parseLog).collect(
                Collectors.toList())
        );
        System.out.println(printer.printTable(ipInfo));
        Table dateInfo = mostPopularDate.collectInformationAboutMostPopularDate(from, to,
            arrayList.stream().map(LogParser::parseLog).collect(
                Collectors.toList())
        );
        System.out.println(printer.printTable(dateInfo));
    }
}
