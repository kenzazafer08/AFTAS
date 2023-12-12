import { Time } from "@angular/common";

export interface Competition{
    code : string;
    Date : Date;
    startTime : Time;
    endTime : Time;
    numberOfParticipants : number;
    Location : string;
    amount : number;
}