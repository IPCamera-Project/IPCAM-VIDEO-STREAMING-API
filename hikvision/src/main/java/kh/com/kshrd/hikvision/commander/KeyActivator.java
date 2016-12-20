package kh.com.kshrd.hikvision.commander;

import kh.com.kshrd.hikvision.service.HikvisionService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created by sophatvathana on 19/12/16.
 */
public class KeyActivator implements BundleActivator {
    private HikvisionCommander commander;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference reference = bundleContext.getServiceReference(HikvisionService.class.getName());

        commander = new HikvisionCommander((HikvisionService) bundleContext.getService(reference), "Hahah");
        commander.setName();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}