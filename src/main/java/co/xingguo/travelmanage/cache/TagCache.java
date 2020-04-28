package co.xingguo.travelmanage.cache;

import co.xingguo.travelmanage.dto.TagDto;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 标签缓存
 * @author Created by hailitortoise on 2020-04-14
 */
public class TagCache {
    public static List<TagDto> get() {
        List<TagDto> tagDtoList = new ArrayList<>();
        TagDto emotion = new TagDto();
        emotion.setCategoryName("区域");
        emotion.setTags(Arrays.asList("省内","国内","海外"));
        tagDtoList.add(emotion);

        TagDto program = new TagDto();
        program.setCategoryName("时长");
        program.setTags(Arrays.asList("一日游","两日游","三日游","七日游","一月游","两月游"));
        tagDtoList.add(program);

        TagDto book = new TagDto();
        book.setCategoryName("价格");
        book.setTags(Arrays.asList("100-500","500-1200","1200-3000","3000-1万","1万以上"));
        tagDtoList.add(book);
        return tagDtoList;
    }

    //拦截相关tag
    public static String filterInValid(String value) {
        String[] split = StringUtils.split(value, ",");
        List<TagDto> tagDtos = get();
        //flatMap 将集合中的集合取出来 将二维数组拍平，得到内部的集合，但是有三个集合啊，取得是那个
        List<String> tagList = tagDtos.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        //!tagList.contains(t) 这个表是前端传输过来的tag，有不是内部的定义的标签，则直接返回报错
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
