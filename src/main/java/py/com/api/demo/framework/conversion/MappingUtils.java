package py.com.api.demo.framework.conversion;

import java.util.List;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import py.com.api.demo.entities.UserEntity;
import py.com.api.demo.web.dto.UserDTO;

/**
 * Mapping Utils
 *
 * Converts from DTO to Entity and the other way. If there is any diference
 * between field naming conventions then should be mapped explicity.
 *
 * @author felipehermosilla
 */
public class MappingUtils {
    private static final MapperFactory mapper = new DefaultMapperFactory.Builder().build();

    static {
        mapper.classMap(UserEntity.class, UserDTO.class)
                .byDefault()
                .register();
 
        mapper.classMap(UserDTO.class, UserEntity.class)
                .byDefault()
                .register();
    }

    private MappingUtils() {
    }

    public static MapperFacade getMapper() {
        return mapper.getMapperFacade();
    }

    public static <T, E> List<E> asList(List<T> source, Class<E> destination) {
        return getMapper().mapAsList(source, destination);
    }

    public static <T, E> E map(T source, Class<E> destination) {
        return getMapper().map(source, destination);
    }
}

