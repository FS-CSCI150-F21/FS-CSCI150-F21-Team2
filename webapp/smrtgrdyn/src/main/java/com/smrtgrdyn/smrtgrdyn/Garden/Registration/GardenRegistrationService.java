package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import com.smrtgrdyn.smrtgrdyn.User.Registration.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.UUID;

@Service
public class GardenRegistrationService {

    private final GardenPairingRepository pairingRepository;
    private final UserInformationRepository userInformationRepository;

    @Autowired
    public GardenRegistrationService(GardenPairingRepository pairingRepository,
                                     UserInformationRepository userInformationRepository){
        this.pairingRepository = pairingRepository;
        this.userInformationRepository = userInformationRepository;
    }

    public UUID requestRegistration(HttpServletRequest servletRequest, GardenRegistrationRequest registrationRequest)  {

        String ipAddress = servletRequest.getHeader("X-Forwarded-for");
        if(ipAddress == null) {
            System.out.println("NUll IP");
            System.out.println(registrationRequest);
            try{
                System.out.println(InetAddress.getLocalHost());
                System.out.println(InetAddress.getLocalHost().getHostName());
            } catch(Exception e){
                e.printStackTrace();
            }
            return UUID.randomUUID();
        }
        if(ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = servletRequest.getHeader("Proxy-Client-IP");
        }

        if(ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = servletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = servletRequest.getRemoteAddr();
        }

        if(!ipAddress.isEmpty()
        && ipAddress.length() < 15
        && ipAddress.indexOf(",") > 0){
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }
        System.out.println(ipAddress);

        return UUID.randomUUID();


    }
}
