

from show_state_array import initialize_tk, state_array, state_display, STATE_WINDOW, test

from tkinter import font

myFont=None

WIDTH = 1920
HEIGHT = 400
TITLE = 'INFO'

NEWS1 = {0:['Hurricane Irma-Themed Cakes Have Hit \nFlorida Grocery Stores',True,'Hurricane season this year has brought devastation and \nchaos everywhere from Texas to the Caribbean.',\
            'How could you be ignorant of this news?','Dozens of images of hurricane-themed baked goods have begun popping up on social media this week.'],
        1: ['Artist Lifts Off After Strapping Herself \nTo 20,000 Helium Balloons',True,'Twenty-thousand. That’s the number of helium-filled balloons \nthat it took to lift an artist off the ground on Sunday during a gravity-defying \nart installation reminiscent of the beloved Pixar movie, “Up.”',\
            'Surprisingly, it has actually happened.','The artist’s concept originated from her experience as \nsomeone who has a physical disability, according to her website.'],
        2: ['Immigrants to be given £8,500 upon arrival to boost economy',False,'No such scheme has been announced at all, \nby either of the UKs major political parties.',\
            'Well, £8,500 is 11398.29 US Dollar. \nIt doesn’t make sense.','43K Facebook users liked this post.'],
        3: ['Tucker Carlson Caught Spreading Racism \nand Fake News On Facebook', False,'There are at least 12 “Tucker Carlson Fox News” groups on \nFacebook that are NOT actually created by Tucker Carlson, \nand the most popular has 200,000 plus members.',\
            'Not Tucker Carlson, but the public is \nactually spreading fake news.','There are only two rules you have to \nfollow in order to start a Facebook group.'],
        4: ['Wendell Callahan Pardoned by Obama, \nKills Three Victims',False,'President Obama neither pardoned Callahan \nnor ordered his early release.',\
            'Not quite true.','Wendell Callahan was arrested and charged with \nthe murders of his girlfriend and two of her children'],
        5: ['We Don\'t need to drink less soda, \naccording to research done by Coca Cola',True,'A network of reputable scientists have helped communicate that \nmore exercise—not less food—is the key to a healthier lifestyle.',\
            'Well, it’s actually a well-known research.','“Exercise is the world\'s best drug.”'],
        6: ['Man Spends $71,000 fighting a $180 speeding ticket',True,'Al Shakarji has spent “at least $71,000” ($100,000 AUD) \non the legal battle. Al Shakarji has represented himself at \nthe five hearings, which include police appealing the \nappeal he initially won.',\
            'Yes, it is a true event.','His family thinks he’s crazy.'],
        7: ['Russia\'s Military Just Bought Five \nBottlenose Dolphins and It Won\'t say Why',True,'It put the contract to supply the dolphins out to tender, \nbut Moscow\'s Utrish Dolphinarium was the only bidder \nbefore the process closed Tuesday.',\
            'That was actually pretty easy. \nI\'m surprised you didn\'t get it.','The ministry will pay $26,000 for the animals, \nat a price of 350,000 rubles ($5,200) per mammal, \naccording to official records.'],
        8: ['Microsoft\'s racist chatbot returns \nwith drug-smoking Twitter Meltdown',True,'Short-lived return saw Tay tweet about smoking drugs in front of \nthe police before suffering a meltdown and being taken offline.',\
            'Yes, it is a true event.','Tay is made in the image of a teenage girl and is designed to \ninteract with millennials to improve its conversational skills \nthrough machine-learning.'],
        9: ['Fire Extinguisher Factory destroyed in Massive Blaze',True,'A Chicago factory that makes chemicals for use in fire \nextinguishers was destroyed in a massive blaze Thursday night.',\
            'That was actually pretty easy. I\'m surprised you didn\'t get it.','Firefighters battled an extra-alarm fire Thursday \nevening in the 4000 block of South Pulaski.'],
        10: ['Police Officer shoots \'Agressive\' Tortoise Dead',True,'A police officer in Uganda has reportedly shot a tortoise dead \nafter being attacked by the "aggressive" creature.',\
             'Well, I agree that the title of \narticle actually seems like fake.','Aggressive Tortoise is not a common one.'],
        11: ['Italian Bank Robbers Wear Trump Masks During Heists',True,'Italian police said on Monday they had arrested two brothers \nsuspected of robbing dozens of cash machines while wearing masks of \nPresident Donald Trump',\
             'That was actually pretty easy. \nI\'m surprised you didn\'t get it.','The stunt evokes the 1991 film "Point Break" \nstarring Keanu Reeves and Patrick Swayze'],
        12: ['A Tick Gets Away At A News Conference About Diseases Ticks Carry',True,'Officials in Miyazaki, Japan, held a news conference to warn about \nthe diseases ticks carry. But a tick got away. \nThey couldn\'t find it and sprayed insecticide in the room.',\
             'Yes, it is a true event.','A live tick and a dead one had been brought \nalong to the event for the press to photograph.'],
        13: ['NASA On 2014 Being The Warmest Year On Record: We’re Pretty Sure, Yeah, That’s It',True,'The year 2014 ranks as Earth’s warmest since 1880, \naccording to two separate analyses by NASA and National Oceanic \nand Atmospheric Administration (NOAA) scientists.',\
             'Not all observations made by NASA are true.','It’s officially posted on the NASA website.']}


NEWS2 = {0:['Burger King says if you publicly admit on LinkedIn that you\'ve been fired, \nyou\'ll get a free burger. They\'re calling it ______________',\
            ['"Whopper Severance"','"King\'s Severance"','"King Care"', '"Take that McDonald\'s"']],
         
         1:['Starbucks Is Giving All Its U.S. Workers A _______',['Raise','Coffee','Bonus fee', 'Reduced salary']],
         
         2:['Museum bids to acquire huge __________ clogging London sewer',['fatberg','dinosaur fossile','Picasso painting', 'egyptian statue']],
         
         3:['Florida Nursing Home Was Supposed To Be A Refuge. \nThen It Became A ‘____________’', ['Death Warehouse',' Homeless people\'s Community','Food Storage', 'House of horror']],
         4:['________ Could Be Double Trouble For iPhone X', ['Twins','Old people','Siblings', 'Face recognition']],
         5:['The Counterintuitive Reason You Shouldn’t Say ‘_______’', ['Sorry','Thank You','Never Mind', 'Yes']],
         6:['Here’s Why ______ Are So Contagious', ['Yawns','Coughing','Hunger', 'Sleeping']],
         7:['This Hotel Offers The Ultimate In Sweet Dreams: \nA 10-Pound _______', ['Doughnut','Cake','Apple Pie', 'Cupcake']],
         8:['Man Proposes To Girlfriend In Front Of ________ ', ['Pope Francis','His Dog','Donald Trump', 'St. Louise Parish']],
         9:['________ Settles Every Overdue Lunch Balance At Pennsylvania Elementary School', ['"Secret Santa"','Bill & Melinda Gates Foundation','State governor', 'Billionaire']],
         10:['Maxwell Brings Viral ______ On Stage To Sing With Him, And He Nails It', ['Cashier','Cleaner','Chef', 'Student']],
         11:['North Korea Fires Another Missile Over ______ As Tensions Mount', ['Japan','South Korea','China', 'Taiwan']]}

def story(s): # display the background story
  content = ''
  if s['level'] == 0:
    content = """You're stranded on an island ruled by a ruthless dictator.
He thinks that truth is whatever the Party says it is.
Can you prove him wrong? He makes you play some games to prove his point that truth means nothing.
A few practice rounds first."""
  elif s['level'] == 1:
    content = """Ok. Now for the real game. Guessing right awards you 1 point.
Getting the answer right within 3 seconds awards you 2 points.
Wrong answers will decrease your score by 1 unless your score is already 0.
Your goal is to reach 5 points to advance to level 2. 3 wrong guesses and you're out.
Be careful: once you get to 3 points you aren't allowed to fall below 3 points again."""
  elif s['level'] == 2:
    content = """You now have to face off against the dictator himself.
Each round you decide whether you want to try to deceive the dictator by sending him fake news or send him real news.
He has to guess which version is real. He then has the chance to do the same thing to you.
If you both guess correctly, each one of you gets 1 point.
If you guess correctly and they don't you get 2 points and they lose 1 point and vice versa.
If you both guess wrong no one gets any points. First to 5 wins. Good luck!"""
  return content

def initialize_vis():
  initialize_tk(WIDTH, HEIGHT, TITLE)
  
def render_state(s):
    global myFont
    if not myFont:
        myFont = font.Font(family="Helvetica", size=18, weight="bold")
    print("In render_state, state is "+str(s))
    # Create the default array of colors
    color1 = (248,200,141)
    color2 = (57,234,168)
    color3 = (243, 176, 187)
    color4 = (159, 220, 242)

    row1 = [color3]+[color4]
    row2 = [color1]+[color2]
    the_color_array = [row1]+[row2]
    # Now create the default array of string labels.
    row1 = ['']+['']
    row2 = ['']+['']
    the_string_array =[row1]+[row2]

    # Adjust colors and strings to match the state.
    if s['level']!=2:
      if s['current_stage']==0:
        content = NEWS1[s['current_question1']][0] # display the content of the news
      elif s['current_stage']==1:
        content = NEWS1[s['finished_questions1'][-2]][2] # display details of the news
      elif s['current_stage'] == 2:
        content = NEWS1[s['finished_questions1'][-2]][3] # display the kidnaper's taunt toward the player
      the_string_array[0][0]= content 
      # display useful state variables to the player
      the_string_array[0][1] = 'Level: '+ str(s['level'])+' out of 2 \nRound: '+str(s['round_count'])+'\nScore: '+str(s['score'])+' out of 5' 

      if s['hint']==1 and s['current_stage']==0: # if 'Hint' is selected, display it.
        the_string_array[1][0] = NEWS1[s['finished_questions1'][-1]][4]
      else:
        the_string_array[1][0] = ''
      the_string_array[0][1]+= '\n'+'Wrong Guesses: '+str(s['wrong_guesses'])+' out of 3'
    else:
      the_string_array[0][1] = 'Level: 2\nRound: '+str(s['round_count'])+'\nScore 1: '+str(s['score1'])+' out of 5\nScore 2: '+str(s['score2'])+' out of 5\nScore: '+str(s['score'])
      if s['current_stage'] == 5:
        txt = ''
        if s['current_player'] == 1:
          txt += 'It is time for Player 2 to guess.'
        elif s['current_player'] == 2:
          txt += 'It is time for Player 2 \nto make up his/her news.'
        elif s['current_player'] == 3:
          txt += 'It is time for Player 1 to guess.'
        elif s['current_player'] == 0:
          txt += 'It is time for Player 1 \nto make up his/her news.'
        else:
          txt += 'aaa'
        the_string_array[0][0] = txt  
        the_string_array[1][0] = ''
        the_string_array[1][1] = ''
      else:
        the_string_array[0][0] = NEWS2[s['current_question2']][0] # display content of the question
        the_string_array[1][0] = ''
        # display useful state variables to the player
        if s['current_player']==0 or s['current_player'] == 2: # at the stage of making up the news
          the_string_array[1][0] += 'Do you want to replace this word / phrase: '+ str(NEWS2[s['current_question2']][1][0])+'?\n'
          the_string_array[1][0] += 'If that\'s the case, which word do you want to use \nto replace this word?\n'
          the_string_array[1][1] += '1. '+str(NEWS2[s['current_question2']][1][1])+'\n2. '+str(NEWS2[s['current_question2']][1][2])+'\n3. '+str(NEWS2[s['current_question2']][1][3])
        else: # at the stage of guessing
          the_string_array[1][0] += 'Which word is real?'
          the_string_array[1][1] += '1. '+str(NEWS2[s['current_question2']][1][0])+'\n2. '+str(s['chosen_fake'])

    caption= story(s)       
    the_state_array = state_array(color_array=the_color_array,
                                  string_array=the_string_array,
                                  text_font=myFont,
                                  caption=caption)
    #print("the_state_array is: "+str(the_state_array))
    the_state_array.show()

    
    

    
