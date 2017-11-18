package ut.ru.stas.jira.plugins.cint;

import org.junit.Test;
import ru.stas.jira.plugins.cint.api.MyPluginComponent;
import ru.stas.jira.plugins.cint.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}