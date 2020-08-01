package br.com.jmw.command;

import br.com.jmw.menu.CommandLineTable;
import org.junit.jupiter.api.Test;

public class Teste {
    public static void main(String[] args) {
        CommandLineTable st = new CommandLineTable();
        //st.setRightAlign(true);//if true then cell text is right aligned
        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        st.setHeaders("id", "groupId", "artifactId","version");//optional - if not used then there will be no header and horizontal lines
        st.addRow("com.tomtom.speedtools:guice", "com.tomtom.speedtools", "guice","3.2.21");
        st.print();

    }


}
