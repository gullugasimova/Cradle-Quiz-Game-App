package de.thu.cradlequizgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Question[] questions = {
            new Question("1.Where does Lindon come from?","Sacred Valley",
                    "Blackflame Empire",
                    "Night Wheel Valley",
                    "Transcendent Ruins",
                    "Desolate Wilds", 1),
            new Question("2.In which book does Lindon reach Truegold?",
                    "Underlord",
                    "Skysworn",
                    "Ghostwater",
                    "Soulsmith",
                    "Uncrowned", 3),
            new Question("3.How did Harmony die?",
                    "Lindon killed him with his own axe",
                    "Orthos killed him",
                    "The Northstrider killed him with his weapon",
                    "Harmony is actually not dead",
                    "He got trapped in the pocket world", 5),
            new Question("4.What is Lindon's path called?",
                    "The Path of Blackflame",
                    "The Path of Twin Stars",
                    "The Path of Hollow King",
                    "The Path of Endless Sword",
                    "The Path of Twin Cores", 2),
            new Question("5.Who was Yerin's first master?",
                    "The Sage of Red Faith",
                    "The Sage of Flowing Sword",
                    "Eithan Arelius",
                    "The Sage of Silver Heart",
                    "The Sage of Endless Sword",5),
            new Question("6.Which type of madra do Lindon's cores contain?",
                    "Blackflame and Sword",
                    "Blackflame and Life",
                    "Fire and Pure",
                    "Blackflame and Pure",
                    "Fire and Dream",4),
            new Question("7.Who resurrected Lindon in the book Unsouled?",
                    "Eithan Arelius",
                    "Suriel the Phoenix",
                    "Li Markuth",
                    "Ozriel the Reaper",
                    "Makiel the Hound",2),
            new Question("8.What are two things Eithan and Lindon have in common?",
                    "Sense of fashion and a white marble",
                    "Pure madra and a white marble",
                    "Pure madra and Arelius bloodline ability",
                    "White marble and two cores",
                    "Two cores and a vision from heavens",2),
            new Question("9.Whose daughter is Mercy?",
                    "Akura Charity",
                    "Northstrider",
                    "Akura Malice",
                    "The Sage of Silver Heart",
                    "Akura Fury",3),
            new Question("10.What are the 3 types of iron body?",
                    "Standard, medium, advanced",
                    "Normal, perfect, advanced perfect",
                    "Basic, normal, perfect",
                    "Basic, perfect, advanced perfect",
                    "Normal, medium, advanced perfect",4),
            new Question("11.What is Lindon's Iron Body called?",
                    "The Bloodshed Iron Body",
                    "The Steel Sword Iron Body",
                    "The Bloodforged Iron Body",
                    "The Puppeteer's Iron Body",
                    "The Raindrop Iron Body", 3),
            new Question("12.What is Eithan's path?",
                    "The Path of Hollow King",
                    "The Path of Thousand Ears",
                    "The Path of Blackflame",
                    "The Path of Pure Madra",
                    "The Path of Thousand Senses", 1),
            new Question("13.What is the first step into Lord realm?",
                    "Connecting yourself to the world",
                    "Sensing the unity of vital aura",
                    "Open up another core",
                    "Open up a soul space",
                    "Connecting with people around you", 4),
            new Question("14.Which method did Eithan use to heal Ziel?",
                    "Pure Storm Baptism",
                    "Pure Heaven Baptism",
                    "Storm and Heaven Baptism",
                    "Heaven and Earth Purification",
                    "Spirit Purification Baptism", 1),
            new Question("15.What are the seven most common aspects of aura?",
                    "Earth, water, wind, fire, heart, ice, space",
                    "Fire, earth, wind, water, force, blood, life",
                    "Time, space, mind, power, reality, soul, love",
                    "Sword, water, force, earth, fire, destruction, shadow",
                    "Fire, water, destruction, shadow, binding, soul, purity", 2),
            new Question("16.What is the goldsign of the Jai Clan?",
                    "Pointed teeth",
                    "Spear arms",
                    "Metal hair",
                    "Pink eyes",
                    "Spear in the back", 3),
            new Question("17.What is the name of the key used in Ghostwater, which eventually becomes part of the Oracle Tree?",
                    "Dragon's Keep",
                    "Sapphire of Knowledge",
                    "Gem of the Deep",
                    "Gem of the Sea",
                    "Eye of the Deep", 5),
            new Question("18.When obtaining his Iron Body, how many sandvipers are used?",
                    "4",
                    "5",
                    "6",
                    "7",
                    "8", 3),
            new Question("19.What responsibility does Arelius clan have in the Blackflame Empire?",
                    "Healing",
                    "Defense",
                    "Cleaning",
                    "Dragon taming",
                    "Agriculture",3),
            new Question("20.Which clan in the Blackflame Empire is known for healing?",
                    "Brightcrown",
                    "Wei Shi clan",
                    "Arelius clan",
                    "Kotai clan",
                    "Naru clan", 1),
            new Question("21.At which place did Lindon, Yerin and Eithan finish the first round of the Uncrowned King tournament respectively?",
                    "1,2,3",
                    "10,11,64",
                    "34,23,64",
                    "10,11,62",
                    "40,41,1",2),
            new Question("22.Who was the judge in the duel between Jai Long and Lindon in Skysworn?",
                    "Jai Daishou",
                    "Naru Huan",
                    "Emperor",
                    "Eithan Arelius",
                    "Naru Gwei",5),
            new Question("23.What sacred weapon was Jai Long looking for in Transcendent Ruins?",
                    "Archstone",
                    "Ancient Spear",
                    "Ancestor's Shield",
                    "Ancestor's Sword",
                    "Ancestor's Spear",5),
            new Question("24.What was Lindon's rank as a True Gold after his first fight with Kiro?",
                    "100",
                    "96",
                    "95",
                    "87",
                    "91",2 ),
            new Question("25.What does Eithan give Lindon, Yerin and Orthos to help them reach True Gold?",
                    "Dream water",
                    "Drop from Heaven",
                    "Heaven's Tears",
                    "Heaven's Drops",
                    "Deep Drop", 4),
            new Question("26.Who created the Ghostwater?",
                    "The Sage of Red Faith",
                    "Akura Malice",
                    "Northstrider",
                    "Akura Charity",
                    "Dreadgods", 3),
            new Question("27.What is the name of the veil that Ozriel used to hide himself?",
                    "The Origin Shroud",
                    "The Origin Veil",
                    "The Hollow Domain",
                    "The Hollow Veil",
                    "The Origin Mantle", 1),
            new Question("28.In which form does Akura Charity follow and observe Lindon?",
                    "Falcon",
                    "Owl",
                    "Tiger",
                    "Fox",
                    "Sparrow", 2),
            new Question("29.What is the name of Eithan's cycling technique?",
                    "Heaven and Blood Purification Wheel",
                    "Heaven and Life Purification Wheel",
                    "Heaven and Earth Purification Wheel",
                    "Earth and Life Purification Wheel",
                    "Blood and Shadow Purification Wheel", 3),
            new Question("30.What is inside the marble that Suriel gave Lindon?",
                    "Blue flame",
                    "Blue ball",
                    "Dark flame",
                    "Blood shadow",
                    "Dark Void", 1),
            new Question("31.Select correct chronological order in which the following characters advanced to Underlord?",
                    "Mercy, Lindon, Yerin",
                    "Yerin, Mercy, Lindon",
                    "Yerin, Lindon, Mercy",
                    "Lindon, Mercy, Yerin",
                    "Mercy, Yerin, Lindon",4),
            new Question("32.What are the requirements to participate in the Uncrowned Tournament?",
                    "Must be an Underlord/lady at the age of 35 or under",
                    "Must be an Overlord/lady at the age of 35 or under",
                    "Must be an Underlord/lady at the age of 40 or under",
                    "Must be a peak Truegold at the age of 35 or under",
                    "Must be an Overlord at the age of 25 or under",1),
            new Question("33.Who was selected from Seishen Kingdom to participate in the Uncrowned King tournament?",
                    "Kiro and Meira",
                    "Kiro and Daji",
                    "Nobody",
                    "Ziel",
                    "Meira",3),
            new Question("34.Who were selected from the Blackflame Empire to participate in the Uncrowned King tournament?",
                    "Lindon, Yerin, Eithan",
                    "Eithan, Naru Gwei, Yerin",
                    "Yerin, Mercy, Eithan",
                    "Eithan, Cassias, Yerin",
                    "Eithan, Naru Saeya, Yerin", 5),
            new Question("35.Who gave Yerin's master his sword?",
                    "Akura Malice",
                    "The Sage of Red Faith",
                    "Dreadgod",
                    "The Sage of Silver Heart",
                    "The Winter Sage",5),
            new Question("36.Whom did the three stars on the Akura emblem use to represent?",
                    "Malice, Fury, Charity",
                    "Malice, Fury, Mercy",
                    "Malice, Charity, Mercy",
                    "Mercy, Charity, Pride",
                    "Mercy, Charity, Fury",1),
            new Question("37.On whom did Yerin use Penance?",
                    "Akura Malice",
                    "Northstrider",
                    "Sha Miara",
                    "Seshethkunaz",
                    "Sophara", 4),
            new Question("38.What was the name of the Sword Sage, who was Yerin's master?",
                    "Adama",
                    "Adam",
                    "Ada",
                    "Percy",
                    "Malok",1),
            new Question("39.What is Ziel's path?",
                    "The Path of the Frozen Blade",
                    "The Path of Lightning Dawn",
                    "The Path of the Hammer Oath",
                    "The Path of the Frozen Hammer",
                    "The Path of the Dawn Oath", 5),
            new Question("40.Who created the weapon Penance?",
                    "Ozriel",
                    "Suriel",
                    "Lindon",
                    "Malice",
                    "Northstrider", 1)
    };

    //the following are to connect the answers to the corresponding question
    private static Map<String, String> answers1 = new HashMap<>();
    private static Map<String, String> answers2 = new HashMap<>();
    private static Map<String, String> answers3 = new HashMap<>();
    private static Map<String, String> answers4 = new HashMap<>();
    private static Map<String, String> answers5 = new HashMap<>();
    private static Map<String, Integer> correctAnswers = new HashMap<>();

    private static ArrayList<String> questionsList = new ArrayList<>();

    static{
        for(Question q: questions){
            questionsList.add(q.getQuestion());
        }

        for(Question q: questions){
            answers1.put(q.getQuestion(),q.getAnswer1());
        }

        for(Question q: questions){
            answers2.put(q.getQuestion(),q.getAnswer2());
        }
        for(Question q: questions){
            answers3.put(q.getQuestion(),q.getAnswer3());
        }
        for(Question q: questions){
            answers4.put(q.getQuestion(),q.getAnswer4());
        }
        for(Question q: questions){
            answers5.put(q.getQuestion(),q.getAnswer5());
        }
        for(Question q: questions){
            correctAnswers.put(q.getQuestion(),q.getCorrect());
        }
    }

    public ArrayList<String> getQuestionsList(){
        return questionsList;
    }

    public int getCorrectAnswer(String question) {
        return correctAnswers.get(question);
    }

    public String getFirstAnswer(String question) {
        return answers1.get(question);
    }
    public String getSecondAnswer(String question) {
        return answers2.get(question);
    }
    public String getThirdAnswer(String question) {
        return answers3.get(question);
    }
    public String getFourthAnswer(String question) {
        return answers4.get(question);
    }
    public String getFifthAnswer(String question) {
        return answers5.get(question);
    }
}
