package ir.mrmoein.demo2.access;



import ir.mrmoein.demo2.repository.impl.UserRepoImpl;
import ir.mrmoein.demo2.service.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public final class LocatorAccess {

    private static final Map<Class<? extends Locator> , Locator> locator = new HashMap<>();

    static {

        UserRepoImpl userRepo = new UserRepoImpl();
        UserServiceImpl userService = new UserServiceImpl(userRepo);

        locator.put(UserServiceImpl.class, userService);
        locator.put(UserRepoImpl.class, userRepo);

    }

    public static <T extends Locator> T getService(Class<T> clazz) {

        Locator access = locator.get(clazz);
        if (access == null){
            throw new RuntimeException(" this class is not Available !!!" + clazz.getName());
        }

        return clazz.cast(access);

    }

}
