package ut.ru.stas.jira.plugins.cint.jira.workflow;

import ru.stas.jira.plugins.cint.jira.workflow.CintCreateOrUpdate;

import com.atlassian.jira.issue.MutableIssue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CintCreateOrUpdateTest
{
    public static final String MESSAGE = "my message";

    protected CintCreateOrUpdate function;
    protected MutableIssue issue;

    @Before
    public void setup() {
        issue = mock(MutableIssue.class);
        when(issue.getDescription()).thenReturn("");

        function = new CintCreateOrUpdate() {
            protected MutableIssue getIssue(Map transientVars) {
                return issue;
            }
        };
    }

    @Test
    public void testNullMessage() throws Exception
    {
        Map transientVars = Collections.emptyMap();
        Map args = Collections.emptyMap();
        function.execute(transientVars, args, null);

        verify(issue).setDescription("");
    }

    @Test
    public void testEmptyMessage() throws Exception
    {
        Map transientVars = new HashMap();
        Map args = Collections.emptyMap();
        transientVars.put("messageField", "");
        function.execute(transientVars, args, null);

        verify(issue).setDescription("");
    }

    @Test
    public void testValidMessage() throws Exception
    {
        Map transientVars = new HashMap();
        Map args = new HashMap();
        transientVars.put("jsonField", MESSAGE);
        args.put("jsonField", MESSAGE);
        function.execute(transientVars, args, null);

        verify(issue).setDescription(MESSAGE);
    }

}
