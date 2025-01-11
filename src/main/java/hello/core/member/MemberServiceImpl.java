package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.repository = memberRepository;
    }

    @Override
    public void join(Member member) {
        repository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return repository.findById(memberId);
    }
}
