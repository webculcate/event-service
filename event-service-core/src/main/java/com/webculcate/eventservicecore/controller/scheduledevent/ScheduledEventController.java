package com.webculcate.eventservicecore.controller.scheduledevent;

import com.webculcate.eventservicecore.model.dto.event.EventCreationRequest;
import com.webculcate.eventservicecore.model.dto.event.EventCreationResponse;
import com.webculcate.eventservicecore.model.dto.event.EventDto;
import com.webculcate.eventservicecore.model.dto.scheduledevent.CreateEventScheduleRequest;
import com.webculcate.eventservicecore.model.dto.scheduledevent.ScheduledEventDto;
import com.webculcate.eventservicecore.model.dto.scheduledevent.ScheduledEventResponse;
import com.webculcate.eventservicecore.service.event.IEventService;
import com.webculcate.eventservicecore.service.scheduledevent.EventSchedulerServiceManager;
import com.webculcate.eventservicecore.service.scheduledevent.IEventSchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("event/schedule/v1")
@RequiredArgsConstructor
public class ScheduledEventController {

    private final EventSchedulerServiceManager eventSchedulerServiceManager;

    @GetMapping("/{id}")
    public ResponseEntity<ScheduledEventDto> getScheduledEvent(@PathVariable("id") Long id) {
        IEventSchedulerService service = eventSchedulerServiceManager.getEventSchedulerService();
        return new ResponseEntity<>(service.getScheduledEvent(id), OK);
    }

    @PostMapping
    public ResponseEntity<ScheduledEventResponse> scheduleEvent(@RequestBody CreateEventScheduleRequest request) {
        IEventSchedulerService service = eventSchedulerServiceManager.getEventSchedulerService();
        return new ResponseEntity<>(service.scheduleEvent(request), OK);
    }

}
