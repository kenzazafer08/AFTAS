import { Competition } from "./competition";
import { Member } from "./member";

export interface Ranking{
    competition : Competition;
    member : Member;
    rank : number;
    score : number;
}