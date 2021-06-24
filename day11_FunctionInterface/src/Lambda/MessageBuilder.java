package Lambda;

@FunctionalInterface
public interface MessageBuilder {
    public abstract String builderMessage(); //注意这里参数返回的是String，不要固定式思维只能是void
}
