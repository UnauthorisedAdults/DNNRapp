package com.unauthorisedadults.dnnr.viewModels;

import androidx.lifecycle.ViewModel;

import com.unauthorisedadults.dnnr.services.GuestNameService;

public class MainViewModel extends ViewModel {

    private GuestNameService guestNameService = new GuestNameService();

    public MainViewModel() {
    }

    public String assignRandomId()
    {
        return guestNameService.getRandomId();
    }
}