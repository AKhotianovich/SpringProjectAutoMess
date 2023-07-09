package by.hotianovich.automess.dto;

public class TagDto {

    private Integer count;
    private String tagName;

    public TagDto(Integer count, String tagName) {
        this.count = count;
        this.tagName = tagName;
    }

    public TagDto() {
    }

    public Integer getCount() { return count; }

    public void setCount(Integer count) { this.count = count; }

    public String getTagName() { return tagName; }

    public void setTagName(String tagName) { this.tagName = tagName; }

    @Override
    public String toString() {
        return "TagDto{" +
                "count=" + count +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
