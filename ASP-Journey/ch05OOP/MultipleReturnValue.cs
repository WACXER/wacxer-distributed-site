public class TextAndNumber
{
    public string Text;
    public int Number;
}

public class  LifeTheUniverseAndEverything
{
    public TextAndNumber GettheData()
    {
        return new TextAndNumber 
        {
            Text = "What's the meaning of life?", 
            Number = 42
        };
    }
}