# -*- coding: utf-8 -*-
import datetime
import random

#<METADATA>
SOLUZION_VERSION = "1.0"
PROBLEM_NAME = "Fact_Fiction"
PROBLEM_VERSION = "0.2"
PROBLEM_AUTHORS = ['Yadi Wang']
PROBLEM_CREATION_DATE = "07-SEP-2017"

# The following field is mainly for the human solver, via either the Text_SOLUZION_Client.
# or the SVG graphics client.
PROBLEM_DESC=\
 '''No description so far.
'''
#</METADATA>

#<COMMON_DATA>

# 'AAA','BBB'and so on represent the content of the news.Please feel free to replance them.

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
        13: [' NASA On 2014 Being The Warmest Year On Record: We’re Pretty Sure, Yeah, That’s It',True,'An elephant walked into a Thailand road to stop a truck traveling \nthrough a national park before stealing a bale of hay \nfrom the back of the vehicle.',\
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

PAST = datetime.datetime.now() # initialize global variable PAST to measure time taken to answer question
FIRST_QUESTION1 = random.randint(0, len(NEWS1)-1) # create the value for the index of first question in level 0
FIRST_QUESTION2 = random.randint(0, len(NEWS2)-1) # create the value for the index of first question in level 2
DILEMMA_LIST = [False,False] # initialize global variable DILEMMA_LIST to record whether player 1 and 2 answer correctly in level 2

#</COMMON_DATA>

#<COMMON_CODE>
class Game_State:
  def __init__(self, dictionary = {'score':0, 'score1':0, 'score2':0, 'level':0, 'round_count':0, 'wrong_guesses':0, 'danger_zone':False,\
                                   'current_player':0, 'current_stage': 0,'current_question1':FIRST_QUESTION1,'finished_questions1':[FIRST_QUESTION1],'hint':0,\
                                   'current_question2':FIRST_QUESTION2, 'finished_questions2':[FIRST_QUESTION2],'chosen_fake':''}):  # Change parameters as needed for your game.
    self.dictionary = dictionary  
  def __copy__(self):
    news = {}
    for i in self.dictionary:
      news[i] = self.dictionary[i]
    return news
  def __str__(self):
    txt = ''
    txt += str(self.dictionary)
    return txt
  def __eq__(self, other):
    if self is other: return True
    if self is None: return False
    if other is None: return False
    return True
  def __hash__(self):
    sum = 0
    factor = 1
    for i in self.dictionary:
      sum += hash(i) * factor
      factor *= 4
    return sum




def copy_state(s): # make a copy of current state
  news = {}
  news['score']=s['score']
  news['score1']=s['score1']
  news['score2']=s['score2']
  news['level'] = s['level']
  news['round_count'] = s['round_count']
  news['wrong_guesses']=s['wrong_guesses']
  news['danger_zone']=s['danger_zone']
  news['current_player']=s['current_player']
  news['current_stage']=s['current_stage']
  news['current_question1'] =s['current_question1']
  news['finished_questions1'] = [0]*len(s['finished_questions1'])
  for i in range(len(s['finished_questions1'])):
    news['finished_questions1'][i]=s['finished_questions1'][i]
  news['hint'] = s['hint']
  news['current_question2'] =s['current_question2']
  news['finished_questions2'] = [0]*len(s['finished_questions2'])
  for j in range(len(s['finished_questions2'])):
    news['finished_questions2'][j]=s['finished_questions2'][j]
  news['chosen_fake'] = s['chosen_fake']
  return news

def can_move(s,op):
  if str(op) == 'Hint' and s['level'] != 1: # 'Hint' is only available in level 1
    return False
  if str(op) == 'Hint' and s['hint'] == 1: #'Hint' is not available if it was already shown
    return False
  if s['level'] == 0 or s['level'] == 1: # in level 0 and level 1, when a question is displayed, 'Next' is not available; when a detail or taunt is displayed, only 'Next' can be used.
    if s['current_stage'] == 0:
      if type(op) != bool and str(op)!='Hint':
        return False
    if s['current_stage'] == 1 or s['current_stage'] == 2:
      if str(op) != 'Next':
        return False
  if s['level'] == 2:
    if str(op).isdigit() == False and str(op) !='Next':# in level 2, True, False, Hint are not available
      return False
    elif s['current_stage'] == 5 and str(op).isdigit() == True: # in level 2, when 2 players are switching positions, they can only use "Next"
      return False
    elif s['current_stage'] == 4 and str(op) == 'Next': # in level 2, when making choices, players cannot use 'Next'
      return False
    elif s['current_player'] == 1 or s['current_player'] == 3:
      if str(op) == '3': # in level 2, when a player is guessing, only 2 choices are available
        return False    
  return True

def check_time(PAST,current): # check whether the player make decision within 5 seconds
  time = (current - PAST).seconds
  if time <= 5:
    return True
  else:
    return False
  
def generate_question_number1(s): # generate random question number and check whether the question was used
  question_number = -1
  while question_number == -1 or question_number in s['finished_questions1']:
    question_number = random.randint(0,len(NEWS1)-1)
  s['finished_questions1'].append(question_number)
  return question_number

def generate_question_number2(s): # generate random question number and check whether the question was used
  question_number = -1
  while question_number == -1 or question_number in s['finished_questions2']:
    question_number = random.randint(0,len(NEWS2)-1)
  s['finished_questions2'].append(question_number)
  return question_number


def move(olds,op):
  global DILEMMA_LIST
  s = copy_state(olds) # start with a deep copy.
  if str(op) == 'Next': # in level 0 or level 1, if Next operator is selected, next question appears.
    if s['level'] == 2:
      s['current_stage'] = 4
    else:
      s['round_count'] += 1
      global PAST
      PAST = datetime.datetime.now() # when next question appears, it starts timing.
      s['hint'] = 0
      s['current_stage'] = 0
      if s['round_count'] == 3 and s['level'] == 0: # when 3 rounds are finished in level 0, the player enters level 1
        s['level'] =1
        s['round_count'] =0
        s['score'] = 0
        PAST = datetime.datetime.now()
        global EX3
        EX3 = False
      if s['score'] >= 5 and s['level']==1: # when the player gets 5+ score, he/she enters level2
        s['level'] = 2
        s['round_count'] = 0
        s['current_stage'] = 5
  elif str(op)!='Next': 
    if s['level'] == 0: # in level 0, if the player chooses the right answer, the detail of the news appears; otherwise the taunt from the kidnapper appears.
      if op == NEWS1[s['current_question1']][1]:
        s['current_stage'] = 1
        s['score']+=1
      else:
        s['current_stage'] = 2
      i = generate_question_number1(s)
      s['current_question1'] = i
    
    elif s['level'] == 1:
      if op == 'Hint': # a hint will appear if the player choose Hint operator
        s['hint'] = 1
      else:
        current = datetime.datetime.now()

		#global PAST
        if_quick = check_time(PAST, current)
        if op == NEWS1[s['current_question1']][1] and if_quick == True: # if the player gets the right answer within 5 seconds, score +2
          s['current_stage'] = 1
          s['score'] += 2
          if s['score'] >=3:
            EX3 = True
        elif op == NEWS1[s['current_question1']][1]: # if the player gets the right answer using more than 5 seconds, score +1
          s['current_stage'] = 1
          s['score'] += 1
          if s['score'] >=3:
            EX3 = True
        else: # if the player gets the wrong answer, score -1
          s['current_stage'] = 2
          if s['score']> 0:
            s['score'] -= 1 
          s['wrong_guesses'] += 1
          if EX3 == True and s['score'] <3: # if the score exceeds and falls below 3, the game ends
            s['danger_zone'] = True
        i = generate_question_number1(s)
        s['current_question1'] = i
  
    else:
      if s['current_player'] == 0 or s['current_player'] == 2: # if player 1 or 2 are making up news
        if s['round_count'] == 0 and s['current_player'] == 0: # special case - first question
          s['chosen_fake'] = NEWS2[FIRST_QUESTION2][1][op]
        else:
          s['chosen_fake'] = NEWS2[s['current_question2']][1][op] # add the chosen fake word to the state
        s['current_player']+=1
      else: # if player 1 or 2 are guessing
        i = generate_question_number2(s) # prepare to generate next news
        s['current_question2'] = i
        if op == 1: # if either player guesses correctly
          if s['current_player'] == 1:
            DILEMMA_LIST[1] = True
          else:
            DILEMMA_LIST[0] = True
        elif op == 2: # if either player guesses incorrectly
          if s['current_player'] == 1:
            DILEMMA_LIST[1] = False
          else:
            DILEMMA_LIST[0] = False
        
        if s['current_player'] == 1: 
            s['current_player']+=1
        else: # at the last stage of each round, add score.
          if DILEMMA_LIST[0]==True and DILEMMA_LIST[1]==True:
            s['score1']+=2
            s['score']+=2
            s['score2']+=2
          elif DILEMMA_LIST[0]==True and DILEMMA_LIST[1]==False:
            s['score1']+=3
            s['score']+=3
          elif DILEMMA_LIST[0]==False and DILEMMA_LIST[1]==True:
            s['score2']+=3
          elif DILEMMA_LIST[0]==False and DILEMMA_LIST[1] == False:
            s['score1']+=1
            s['score']+=1
            s['score2']+=1
          s['current_player'] = 0
          s['round_count']+=1
      s['current_stage'] = 5
  return s         


def describe_state(s):
  txt = ''
  txt += 'Score: '+str(s['score'])+'\n'
  if level == 1:
    txt += 'Wrong Guesses' + str(s['wrong_guesses'])+'\n'
  txt += 'Round: '+str(s['round_count'])+'\n'
  txt += 'Level: '+str(s['score'])+'\n'
  return txt

def goal_test(s):
  return s['score1']>=5 or s['score2']>=5 or s['danger_zone'] == True or s['wrong_guesses'] == 3

def goal_message(s):
  if s['score1']==5:
    return "Congratulations on successfully reaching the goal state!"
  else:
    return "You lost the game."

class Operator:
  def __init__(self, name, precond, state_transf):
    self.name = name
    self.precond = precond
    self.state_transf = state_transf

  def is_applicable(self, s):
    return self.precond(s)

  def apply(self, s):
    return self.state_transf(s)
#</COMMON_CODE>

#<INITIAL_STATE>

INITIAL_STATE = {'score':0, 'score1':0, 'score2':0, 'level':0, 'round_count':0, 'wrong_guesses':0, 'danger_zone':False, \
                 'current_player':0, 'current_stage': 0,'current_question1':FIRST_QUESTION1,'finished_questions1':[FIRST_QUESTION1],'hint':0, \
                 'current_question2':FIRST_QUESTION2, 'finished_questions2':[FIRST_QUESTION2],'chosen_fake':''}
#</INITIAL_STATE>

#<OPERATORS>
Operators = [True, False,'Next','Hint',1,2,3]

OPERATORS = [Operator(
  str(op),
  lambda s, op1 = op:can_move(s,op1),
  lambda s, op1 = op: move(s,op1) ) 
  for op in Operators]
#</OPERATORS>

#<GOAL_TEST> (optional)
GOAL_TEST = lambda s: goal_test(s)
#</GOAL_TEST>

#<GOAL_MESSAGE_FUNCTION> (optional)
GOAL_MESSAGE_FUNCTION = lambda s: goal_message(s)
#</GOAL_MESSAGE_FUNCTION>

#<STATE_VIS>
render_state = None
  
def use_BRIFL_SVG():
  global render_state
  from  Fact_Fiction_SVG_VIS_FOR_BRIFL import render_state
#</STATE_VIS>

