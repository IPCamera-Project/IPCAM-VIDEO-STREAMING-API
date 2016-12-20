package kh.com.kshrd.hikvision;

import kh.com.kshrd.hikvision.service.HikvisionService;
import kh.com.kshrd.hikvision.service.impl.HikvisionServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Created by sophatvathana on 19/12/16.
 */
public class ServiceProvider implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        registration = bundleContext.registerService(
                HikvisionService.class.getName(),
                new HikvisionServiceImpl(),
                null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        registration.unregister();
    }
}