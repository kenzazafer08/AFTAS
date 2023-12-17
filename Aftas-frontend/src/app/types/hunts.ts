import { Competition } from "./competition";
import { Fish } from "./fish";

export interface hunts{
    competition : Competition,
    fish : Fish,
    numberOfFishes: number
    member : number,
    id : number
}